package com.dimples.sys.configure;

import com.dimples.sys.properties.DimplesSwaggerProperties;
import com.dimples.sys.properties.DimplesSystemProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/12
 */
@Slf4j
@Configuration
@EnableSwagger2
public class DimplesSysSwagger2Config {

    @Resource
    private DimplesSystemProperties properties;

    @Bean
    public Docket createRestApi() {
        log.info("==================== 开启Swagger2配置 ====================");
        log.info("=============== 访问网址：IP:Port/doc.html ================");
        DimplesSwaggerProperties swagger = properties.getDimplesSwaggerProperties();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(swagger))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(DimplesSwaggerProperties swagger) {
        Contact contact = new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail());
        return new ApiInfoBuilder()
                .title(swagger.getTitle())
                .description(swagger.getDescription())
                .contact(contact)
                .version(swagger.getVersion())
                .license(swagger.getLicense())
                .licenseUrl(swagger.getLicenseUrl())
                .build();
    }

}