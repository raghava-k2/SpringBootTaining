package com.gaman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootSecurityWithFirebaseOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityWithFirebaseOauth2Application.class, args);
	}

}
