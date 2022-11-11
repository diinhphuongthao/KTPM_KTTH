package com.example.OrderService.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
@Getter@Setter
public class Order {
	@Id
	@Column(name = "orderId", columnDefinition = "varchar(9)")
	private String id;
	private String name;
	private double price;
	private String customerId;
}