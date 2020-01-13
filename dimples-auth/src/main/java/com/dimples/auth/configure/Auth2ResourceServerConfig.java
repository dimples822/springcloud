package com.dimples.auth.configure;

import com.dimples.auth.properties.AuthProperties;
import com.dimples.common.handler.AuthAccessDeniedHandler;
import com.dimples.common.handler.AuthExceptionEntryPoint;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import lombok.extern.slf4j.Slf4j;

/**
 * 资源服务器
 * 认证中心会提供User信息，注销当前Token等，所以也是资源服务器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Slf4j
@Configuration
@EnableResourceServer
public class Auth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String SECURITY_ALL_UTL = "/**";

    private AuthProperties authProperties;
    private AuthAccessDeniedHandler accessDeniedHandler;
    private AuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    public Auth2ResourceServerConfig(AuthAccessDeniedHandler accessDeniedHandler, AuthExceptionEntryPoint exceptionEntryPoint, AuthProperties authProperties) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.exceptionEntryPoint = exceptionEntryPoint;
        this.authProperties = authProperties;
    }

    /**
     * requestMatchers().antMatchers("/**")的配置表明该安全配置对所有请求都生效
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(authProperties.getAnonUrl(), ",");
        log.info("============ Auth模块资源服务器免认证配置：{}", (Object) anonUrls);
        http.csrf().disable()
                .requestMatchers().antMatchers(SECURITY_ALL_UTL)
                .and()
                // 授权配置
                .authorizeRequests()
                // 免认证路径
                .antMatchers(anonUrls).permitAll()
                // 所有请求：/**
                .antMatchers(SECURITY_ALL_UTL)
                // 都需要认证
                .authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

    /**
     * 配置jwt生成token的转换
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.txt");
        String publicKey;
        try {
            publicKey = IOUtils.toString(resource.getInputStream());
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }

}



















