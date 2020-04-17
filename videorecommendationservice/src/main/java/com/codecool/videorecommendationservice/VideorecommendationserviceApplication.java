package com.codecool.videorecommendationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VideorecommendationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideorecommendationserviceApplication.class, args);
	}

}
