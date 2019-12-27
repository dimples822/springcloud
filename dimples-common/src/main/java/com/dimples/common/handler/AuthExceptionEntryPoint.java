package com.dimples.common.handler;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.result.R;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源服务器认证失败
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        R.makeResponse(response, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_UNAUTHORIZED, R.error(CodeAndMessageEnum.AUTH_DISABLE));
    }

}
















