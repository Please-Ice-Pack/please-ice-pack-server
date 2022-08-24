package com.kurly.pip.config.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class MLFeignClientConfig {

	@Bean
	Logger.Level githubFeignClientLoggerLevel() {
		return Logger.Level.FULL;
	}
}