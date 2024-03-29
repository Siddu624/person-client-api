package com.cloudservices.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EurekaClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServiceApplication.class, args);
	}

}
