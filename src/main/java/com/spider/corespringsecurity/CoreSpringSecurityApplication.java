package com.spider.corespringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CoreSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreSpringSecurityApplication.class, args);
	}

}
