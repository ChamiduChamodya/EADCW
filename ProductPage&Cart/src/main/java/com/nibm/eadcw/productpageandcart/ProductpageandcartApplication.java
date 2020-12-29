package com.nibm.eadcw.productpageandcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductpageandcartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductpageandcartApplication.class, args);
    }

}
