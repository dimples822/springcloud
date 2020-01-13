package com.dimples.zuul.filter;

import com.dimples.common.constant.Constant;
import com.dimples.common.transport.ResponseDTO;
import com.dimples.common.utils.HttpContextUtil;
import com.dimples.zuul.properties.DimplesGatewayProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Base64Utils;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 网关转发请求前的过滤器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/3
 */
@Slf4j
@Component
public class ZuulGatewayRequestFilter extends ZuulFilter {

    @Resource
    private DimplesGatewayProperties properties;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        if (StringUtils.equals(host, HttpContextUtil.LOCAL_ADDRESS)) {
            host = HttpContextUtil.LOOPBACK_ADDRESS;
        }
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);

        // 禁止外部访问资源实现
        boolean shouldForward = true;
        String forbidRequestUri = properties.getForbidRequestUri();
        String[] forbidRequestUris = StringUtils.splitByWholeSeparatorPreserveAllTokens(forbidRequestUri, ",");
        if (forbidRequestUris != null && ArrayUtils.isNotEmpty(forbidRequestUris)) {
            for (String u : forbidRequestUris) {
                if (pathMatcher.match(u, uri)) {
                    shouldForward = false;
                }
            }
        }
        if (!shouldForward) {
            HttpServletResponse response = ctx.getResponse();
            try {
                ResponseDTO.makeResponse(response,
                        MediaType.APPLICATION_JSON_VALUE,
                        HttpServletResponse.SC_FORBIDDEN,
                        ResponseDTO.failed("该URI不允许外部访问"));
                ctx.setSendZuulResponse(false);
                ctx.setResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        byte[] token = Base64Utils.encode((Constant.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(Constant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }

}



















