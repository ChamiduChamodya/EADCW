package com.nibm.eadcw.productcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductcrudApplication.class, args);
    }

}
