package com.dimples.common.annotation;

import com.dimples.common.validator.MobileValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}