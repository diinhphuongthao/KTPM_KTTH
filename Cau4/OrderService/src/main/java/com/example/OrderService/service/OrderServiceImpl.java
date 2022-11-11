package com.example.OrderService.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.dao.CustomerDao;
import com.example.OrderService.dao.OrderDao;
import com.example.OrderService.entity.Order;
import com.example.OrderService.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository repo;
	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return repo.save(order);
	}

	@Override
	public OrderDao getOneOrder(String id) {
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
	      Order bill = repo.findById(id).get();
	      String passengerId = bill.getCustomerId();
	      CustomerDao passDto = restTemplate.exchange("http://localhost:4001/customers"
	    		  .concat("/")
	    		  .concat(passengerId),
	    		  	HttpMethod.GET, 
					 entity, 
					 CustomerDao.class
					).getBody();
	      OrderDao billDto = OrderDao.builder()
	    		  .id(bill.getId())
	    		  .name(bill.getName())
	    		  .price(bill.getPrice())
	    		  .customer(passDto)
	    		  .build();
		return billDto;
	}

}
