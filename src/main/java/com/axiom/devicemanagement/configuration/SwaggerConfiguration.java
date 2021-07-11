package com.axiom.devicemanagement.configuration;

import static java.util.Collections.emptyList;

/**
 * Configuration class which enables Swagger
 *
 * @author Hemavathi
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket apis(ConfigurableEnvironment environment) {
		return new Docket(DocumentationType.SWAGGER_2).host(environment.getProperty("config.host"))
				.groupName(environment.getProperty("spring.application.name")).useDefaultResponseMessages(false)
				.forCodeGeneration(true).select()
				.apis(RequestHandlerSelectors.basePackage("com.axiom.devicemanagement")).paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfo("Device Management Service ", "Device Management API Documentation", "1.0.0",
						"https://developer.sunil.com/api-catalogue",
						new Contact("Device API", "http://www.sunil.ae", "sunil@gmail.com"), "API license 1.0",
						"https://developer.device.com/api-catalogue", emptyList()));

	}
}
