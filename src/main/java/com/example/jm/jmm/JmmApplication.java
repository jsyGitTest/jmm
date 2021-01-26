package com.example.jm.jmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

@EnableCaching

public class JmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmmApplication.class, args);
	}

}
