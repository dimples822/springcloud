package com.dimples.auth.handler;

import com.dimples.common.result.R;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
public class AuthAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        R.makeResponse(response, MediaType.APPLICATION_JSON_VALUE,
                HttpServletResponse.SC_FORBIDDEN, R.error("没有权限访问该资源"));
    }

}














