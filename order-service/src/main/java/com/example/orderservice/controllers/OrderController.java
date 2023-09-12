package com.example.orderservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entities.Order;
import com.example.orderservice.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		List<Order> orders = service.getAll();
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Order>> getById(@PathVariable Long id) throws Exception{
		Optional<Order> order = service.getById(id);
		if(order.isPresent()) {
			return ResponseEntity.ok(order);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Order postOrder(Order order) throws Exception {
		Order neworder = service.createOrder(order);
		
		return neworder;
	}
	
	@DeleteMapping
	public void deleteOrderById(Order order) throws Exception {
		service.deleteOrderById(order);
	}
	
}