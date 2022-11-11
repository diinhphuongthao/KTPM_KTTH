package com.example.OrderService.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDao {
	private String id;
	private String name;
	private double price;
	private CustomerDao customer;
}
