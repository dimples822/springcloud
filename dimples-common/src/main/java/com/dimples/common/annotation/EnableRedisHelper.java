package com.dimples.common.annotation;

import com.dimples.common.config.RedisConfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置redis操作类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisConfigure.class)
public @interface EnableRedisHelper {
}
