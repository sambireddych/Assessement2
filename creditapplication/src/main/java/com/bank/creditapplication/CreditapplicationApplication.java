package com.bank.creditapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableHystrix
@EnableHystrixDashboard
public class CreditapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditapplicationApplication.class, args);
	}

}
