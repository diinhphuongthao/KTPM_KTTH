package com.example.CustomerService.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository repo;
	@Override
	public Customer getOnePass(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer addPass(Customer pass) {
		// TODO Auto-generated method stub
		return repo.save(pass);
	}

}
