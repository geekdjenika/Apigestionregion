package com.malitourist.Apigestionregion.Modele;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SwaggerConfig {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()  
	           .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
	           .paths(PathSelectors.any()).build().pathMapping("/")
	           .apiInfo(apiInfo()).useDefaultResponseMessages(false);
	    }

	    @Bean
	    public ApiInfo apiInfo() {
	        final ApiInfoBuilder builder = new ApiInfoBuilder();
	        builder.title("Bienvenue, ici vous pouvez tester les fonctionnaliés de notre API de gestion des régions du Mali!").version("1.0").license("(C) MaliTourist 2022")
	        .description("Liste de toutes les fonctionnalités de l'API à travers Swagger UI");
	        return builder.build();
	        }
}
