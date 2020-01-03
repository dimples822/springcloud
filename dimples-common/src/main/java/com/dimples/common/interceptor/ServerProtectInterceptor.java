package com.dimples.common.interceptor;

import com.dimples.common.constant.Constant;
import com.dimples.common.transport.ResponseDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务防护拦截器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/3
 */
public class ServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(Constant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(Constant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            ResponseDTO.makeResponse(response, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_FORBIDDEN, ResponseDTO.failed("请通过网关获取资源"));
            return false;
        }
    }

}





















