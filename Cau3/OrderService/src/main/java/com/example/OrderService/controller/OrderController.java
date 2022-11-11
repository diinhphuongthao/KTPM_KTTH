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

import io.github.resilience4j.retry.annotation.Retry;




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
	@Retry(name = "customer")
	public OrderDao getOne(@PathVariable String id) {
		try {
	        System.out.println(Thread.currentThread().getName() + "time wait retry  "+
	                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        
	    } catch (Exception e){
	        System.out.println(e.getLocalizedMessage());
	    }
		return service.getOneOrder(id);
	}
	@PostMapping()
	public Order addOrder(@RequestBody Order order) {
		return service.addOrder(order);
	}
}
