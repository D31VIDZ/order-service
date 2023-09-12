package com.example.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderservice.entities.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{

}
