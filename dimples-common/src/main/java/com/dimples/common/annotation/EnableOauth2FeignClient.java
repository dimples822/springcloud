package com.dimples.common.annotation;

import com.dimples.common.configure.Oauth2FeignConfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/2
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(Oauth2FeignConfig.class)
public @interface EnableOauth2FeignClient {
}
