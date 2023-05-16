package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swagConfig() {
		return new Docket(DocumentationType.SWAGGER_2).
				select()
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfo("Student Api","Student Course Description","1.0","http://localhost:8080",new Contact("name","url","test@gmail.com")
						,"opensource","",Collections.EMPTY_LIST));
	}
}
