package com.kurly.pip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PipApplication.class, args);
	}

}
