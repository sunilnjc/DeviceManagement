package com.axiom.devicemanagement.configuration;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Configuration class which enables Swagger
 *
 * @author Hemavathi
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Axioms- Api")//
				.apiInfo(apiInfo())//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.axiom.devicemanagement.controller"))//
				.paths(postPaths()).build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/products/v1/devices.*"), regex("/products/v1/devices.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Device Management API")
				.description("Lists the Devices available based on your search").termsOfServiceUrl("http://axiom.com")
				.licenseUrl("hemavathi@gmail.com").version("1.0").build();
	}

}
