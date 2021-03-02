package com.nibm.EADCW.createGroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreateGroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateGroupApplication.class, args);
	}
}
