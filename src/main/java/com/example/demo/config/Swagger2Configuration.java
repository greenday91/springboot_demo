package com.example.demo.config;


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

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2Configuration {

        @Bean
        public Docket api()
        {
            ParameterBuilder tokenPar = new ParameterBuilder();
            List<Parameter> pars = new ArrayList<>();
            tokenPar.name("authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
            pars.add(tokenPar.build());
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                    .select()
                    // 自行修改为自己的包路径
                    .apis(RequestHandlerSelectors
                            .basePackage("com.example.demo.web.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .globalOperationParameters(pars);
        }

        // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
        private ApiInfo apiInfo()
        {
            return new ApiInfoBuilder()
                    // 页面标题
                    .title("chenzyArticle系统-api文档")
                    // 创建人
                    .contact("chenzy")
                    // 版本号
                    .version("1.0")
                    // 描述
                    .description("API 描述")
                    .build();
        }



}
