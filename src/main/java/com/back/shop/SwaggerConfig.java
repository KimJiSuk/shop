package com.back.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("X-AUTH-TOKEN")
                .description("Access Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(new ArrayList<>(Collections.singleton(parameterBuilder.build())))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.back.shop"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shop Rest API")
                .description("Shop Description")
                .version("1")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("jskim", "", "yes0229@gmail.com"))
                .build();
    }
}
