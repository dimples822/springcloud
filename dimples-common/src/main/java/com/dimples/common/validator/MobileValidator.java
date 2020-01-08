package com.dimples.common.validator;

import com.dimples.common.annotation.IsMobile;
import com.dimples.common.constant.RegexpConstant;
import com.dimples.common.utils.DimplesUtil;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return DimplesUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
