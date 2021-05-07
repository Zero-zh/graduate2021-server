package com.graduate.loyee.utils.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    //根据Controller包的位置去区分是否需要token认证


    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        List<Parameter> pars = new ArrayList<Parameter>();

        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token").description("token")
            .modelRef(new ModelRef("String")).parameterType("header")
            .required(true).build(); //header中的Token参数必填，但是这里不能解决部分接口不需要token参数

        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.graduate.loyee.controller.authApi"))
            .paths(PathSelectors.any())
            .build().groupName("需要token验证").globalOperationParameters(pars).ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
    }

    @Bean
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.graduate.loyee.controller.publicApi"))
            .paths(PathSelectors.any())
            .build().groupName("无需token验证").ignoredParameterTypes(HttpServletResponse.class, HttpServletRequest.class);
    }

    //配置Swagger文档的基本信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("Loyee2021届毕业论文接口文档")
            .description("简单优雅的restful风格接口")
            .termsOfServiceUrl("http://baidu.com")
            .version("1.0")
            .build();
    }
}
