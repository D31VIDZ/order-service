package com.example.orderservice.servicesclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderservice.dots.CustomerDTO;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {

	@GetMapping("/customer/{id}")
	ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id);	
}