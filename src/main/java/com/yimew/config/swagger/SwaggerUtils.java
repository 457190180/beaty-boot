//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.swagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerUtils {
    public SwaggerUtils() {
    }

    private static ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("beauty RESTful APIs").version("1.0").build();
    }

    public static Docket initDocket() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }
}
