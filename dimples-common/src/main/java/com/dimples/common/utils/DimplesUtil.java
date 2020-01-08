package com.dimples.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
public class DimplesUtil {

    /**
     * 正则校验
     *
     * @param regex 正则表达式字符串
     * @param value 要匹配的字符串
     * @return 正则校验结果
     */
    public static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
