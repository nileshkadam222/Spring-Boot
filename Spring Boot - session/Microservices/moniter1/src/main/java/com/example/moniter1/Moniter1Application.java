package com.example.moniter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Moniter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Moniter1Application.class, args);
	}

}
