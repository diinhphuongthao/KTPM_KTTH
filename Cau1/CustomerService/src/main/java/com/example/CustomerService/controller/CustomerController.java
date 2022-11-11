package com.example.CustomerService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.service.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping()
	public List<Customer> getAll(){
		return service.getAll();
	}
	@GetMapping("/{id}")
	public Customer getOnePass(@PathVariable String id) {
		return service.getOnePass(id);
	}
	@PostMapping()
	public Customer addPass(@RequestBody Customer pass) {
		return service.addPass(pass);
	}
}

