package com.restapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.restapi"})
public class RestApiFamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiFamaApplication.class, args);
	}

}
