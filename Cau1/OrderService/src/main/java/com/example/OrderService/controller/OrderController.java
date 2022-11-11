package com.example.OrderService.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.dao.OrderDao;
import com.example.OrderService.entity.Order;
import com.example.OrderService.service.OrderService;




@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping()
	public List<Order> getAll(){
		return service.getAllOrder();
	}
	@GetMapping("/{id}")
	public OrderDao getOne(@PathVariable String id) {
		return service.getOneOrder(id);
	}
	@PostMapping()
	public Order addBill(@RequestBody Order bill) {
		return service.addOrder(bill);
	}
}
