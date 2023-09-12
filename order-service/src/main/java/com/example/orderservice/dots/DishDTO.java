package com.example.orderservice.dots;

public class DishDTO {

	private Long Id;
	
	private String name;
	
	private Double price;

	public DishDTO() {
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
