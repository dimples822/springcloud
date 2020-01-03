package com.dimples.zuul.filter;

import com.dimples.common.constant.Constant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;

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
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);
        byte[] token = Base64Utils.encode((Constant.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(Constant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }

}



















