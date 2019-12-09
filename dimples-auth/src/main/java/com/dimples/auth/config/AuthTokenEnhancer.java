package com.dimples.auth.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在访问令牌中添加一些自定义声明
 * 定义一个TokenEnhancer来定制我们的Access Token与这些额外的声明
 * 如：添加一个额外的字段“组织”到我们的访问令牌
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
public class AuthTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>(5);
        additionalInfo.put("organization", "dimples");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}














