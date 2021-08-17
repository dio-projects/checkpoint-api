package io.schuberty.dio.checkpointapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket apiManager() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("io.schuberty.dio.checkpointapi"))
            .paths(PathSelectors.ant("/api/v1/**"))
            .build()
            .apiInfo(metaData());
            // .globalOperationParameters(
            //     Collections.singletonList(
            //         new ParameterBuilder()
            //             .name("Authorization")
            //             .description("Header for JWT Token")
            //             .modelRef(new ModelRef("string"))
            //             .parameterType("header")
            //             .required(false)
            //             .build()));
    }

    public ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("Checkpoint API")
            .description("")
            .version("0.0.3")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .contact(new Contact("Schubert", "https://github.com/schuberty/", ""))
            .build();
    }
}