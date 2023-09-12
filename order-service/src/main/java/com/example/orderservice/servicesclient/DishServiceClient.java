package com.example.orderservice.servicesclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderservice.dots.DishDTO;

@FeignClient(name = "menu-service")
public interface DishServiceClient {

	@GetMapping("/menu/{id}")
	ResponseEntity<DishDTO> getDishById(@PathVariable Long id);	
}
