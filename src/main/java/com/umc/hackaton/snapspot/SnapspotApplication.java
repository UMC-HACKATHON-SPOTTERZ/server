package com.umc.hackaton.snapspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SnapspotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapspotApplication.class, args);
	}

}
