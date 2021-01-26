package com.nibm.eadcw.loginandregis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginandregisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginandregisApplication.class, args);
    }

}
