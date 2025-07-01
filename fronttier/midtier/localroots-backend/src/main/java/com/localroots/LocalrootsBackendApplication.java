package com.localroots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.localroots.controller", "com.localroots.service", "com.localroots.exception", "com.localroots.config"})
public class LocalrootsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalrootsBackendApplication.class, args);
	}

}
