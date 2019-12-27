package com.dimples.zuul.filter;

import com.dimples.common.result.R;
import com.netflix.zuul.context.RequestContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 处理zuul异常信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
@Slf4j
@Component
public class ZuulGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            R authResponse = resolveExceptionMessage(message, serviceId);

            HttpServletResponse response = ctx.getResponse();
            R.makeResponse(response, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, authResponse);
            log.error("Zuul sendError：{}", authResponse.getMsg());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private R resolveExceptionMessage(String message, String serviceId) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return R.error("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return R.error(serviceId + "服务不可用");
        }
        return R.error("Zuul请求" + serviceId + "服务异常");
    }

}
