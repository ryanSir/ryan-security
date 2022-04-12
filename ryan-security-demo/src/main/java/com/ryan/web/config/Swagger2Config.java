package com.ryan.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger config
 * 
 * @author Ryan
 * @version Id: SwaggerConfig, v 0.1 2021/10/27 下午2:35 ryan Exp $
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enable}")
    private boolean enable;

    /**
     * 配置swagger2核心配置 docket
     * <p>
     * http://localhost:8088/swagger-ui.html
     * http://localhost:8088/doc.html
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ryan.web.async"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring security 接口文档")
                .description("spring security 接口文档")
                .version("1.0")
                .build();
    }

}