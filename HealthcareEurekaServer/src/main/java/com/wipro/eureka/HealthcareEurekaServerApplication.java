package com.wipro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class HealthcareEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareEurekaServerApplication.class, args);
	}

}
