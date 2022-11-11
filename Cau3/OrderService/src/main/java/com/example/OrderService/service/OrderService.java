package com.example.OrderService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OrderService.dao.OrderDao;
import com.example.OrderService.entity.Order;

@Service
public interface OrderService {
	OrderDao getOneOrder(String id);

	List<Order> getAllOrder();

	Order addOrder(Order order);
}
