package com.example.orderservice.services;

import java.util.List;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.orderservice.dots.CustomerDTO;
import com.example.orderservice.dots.DishDTO;
import com.example.orderservice.entities.Order;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.servicesclient.CustomerServiceClient;
import com.example.orderservice.servicesclient.DishServiceClient;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	CustomerServiceClient customerService;
	
	@Autowired
	DishServiceClient dishService;
	
	public Order createOrder(Order order) throws Exception {
		
		try {
			ResponseEntity<CustomerDTO> customerResponse = customerService.getCustomerById(order.getCostumerId());
			
			if(customerResponse.getStatusCode() != HttpStatus.OK) {
				throw new Exception("customer Id invalido");
			}
			
			ResponseEntity<DishDTO> dishResponce = dishService.getDishById(order.getDishId());

			if(dishResponce.getStatusCode() != HttpStatus.OK) {
				throw new Exception("dish Id invalido");
			}
			
			repository.save(order);
			return order;
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Erro ao validar Ids", e);
		}
	}
	
	public List<Order> getAll(){
		List<Order> orders = repository.findAll();
		return orders;
		
	}
	
	public Optional<Order> getById(Long Id) throws Exception{
		
		Optional<Order> order = repository.findById(Id);
		
		if(order.isEmpty()) {
			throw new Exception("serviço não encontrado");
		}else {
			return order;
		}		
	}
	
	public void deleteOrderById(Order order) throws Exception {
		if(order == null) {
			throw new Exception("serviço não encontrado");
		}else {
			repository.delete(order);
		}		
	}
}