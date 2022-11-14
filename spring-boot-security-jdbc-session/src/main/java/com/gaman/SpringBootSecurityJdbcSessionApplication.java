package com.gaman;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableEncryptableProperties
@EnableWebSecurity
@EnableJdbcHttpSession
public class SpringBootSecurityJdbcSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJdbcSessionApplication.class, args);
	}

}
