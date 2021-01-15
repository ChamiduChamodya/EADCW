package com.nibm.EADCW.paymentandnotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentandnotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentandnotifyApplication.class, args);
	}

}
