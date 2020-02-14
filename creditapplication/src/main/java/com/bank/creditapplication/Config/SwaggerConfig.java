package com.bank.creditapplication.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "Shipping API",
                        "APIs for working with Shipping in the Sales Order System.",
                        "v1",
                        "https://northwind.com/apis/termsofservice",
                        new Contact("Northwind Support", "https://northwind.com/support", "support@northwind.com"),
                        "End User License Agreement",
                        "https://northwind.com/apis/eula",
                        Collections.EMPTY_LIST));
    }

}