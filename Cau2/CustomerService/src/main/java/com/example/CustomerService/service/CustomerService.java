package com.example.CustomerService.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CustomerService.entity.Customer;


@Service
public interface CustomerService {
	Customer getOnePass(String id);
	List<Customer> getAll();
	Customer addPass(Customer pass);
}

