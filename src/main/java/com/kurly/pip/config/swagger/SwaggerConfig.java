package com.kurly.pip.config.swagger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@ConditionalOnWebApplication
@Configuration
@Slf4j
class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.groupName("Api Document")
			.select()
			.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
			.paths(PathSelectors.ant("/api/**"))
			.build()
			.useDefaultResponseMessages(false)
			.apiInfo(apiInfo())
			.directModelSubstitute(Pageable.class, SwaggerPageableRequest.class)
			.securitySchemes(Collections.singletonList(apiKey()))
			.securityContexts(Collections.singletonList(securityContext()));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
			.securityReferences(Collections.singletonList(securityReference()))
			.build();
	}

	private SecurityReference securityReference() {
		return SecurityReference.builder()
			.reference("Bearer + JWT")
			.scopes(new AuthorizationScope[] {new AuthorizationScope("global", "access All")})
			.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Bearer + JWT", "Authorization", "header");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("PleaseIcePack API ??????")
			.description(getMainDescription())
			.build();
	}

	private String getMainDescription() {
		StringBuilder sb = new StringBuilder();
		try {
			ClassPathResource resource = new ClassPathResource("static/mainDescription.html");
			Path path = Paths.get(resource.getURI());
			List<String> content = Files.readAllLines(path);
			content.forEach(sb::append);
		} catch (IOException e) {
			log.error("Main Description Error: {}", e.getMessage());
		}
		return sb.toString();
	}
}