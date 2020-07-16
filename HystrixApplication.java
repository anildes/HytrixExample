package com.anil.demohystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class HystrixApplication {
	@Autowired
	private Fallback fallback;

	@RequestMapping(path = "/test-hystrix",  produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String toRead() {
		System.out.println("Call readProductDetails");
		String s = fallback.readProductDetails();

		return s;

	}



	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}