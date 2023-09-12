package com.example.orderservice.entities;

import javax.validation.constraints.Positive;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "costumer_id")
	private Long costumerId;
	
	
	@Column(name = "dish_id")
	private Long dishId;
	
	@Positive
	private Integer quantity;
	
	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(Long costumerId) {
		this.costumerId = costumerId;
	}

	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}
}