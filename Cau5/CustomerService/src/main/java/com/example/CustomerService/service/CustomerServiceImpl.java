package com.example.CustomerService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.CustomerService.entity.Customer;
import com.example.CustomerService.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	private static final String REDIS_CACHE_VALUE = "passenger";
	@Autowired
	private CustomerRepository repo;
	@Autowired
	private RedisTemplate template;

	@Override
	public Customer getOnePass(String id) {
		Customer pass = null;
		pass = (Customer) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if (pass != null)
			return pass;
		System.out.println("get customer from db...");
		pass = repo.findById(id).get();
		if (pass.getId() != null)
			template.opsForHash().put(REDIS_CACHE_VALUE, pass.getId(), pass);
		return pass;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> ls = (List<Customer>) template.opsForHash().values(REDIS_CACHE_VALUE);
		if (ls.size() > 0)
			return ls;
		ls = repo.findAll();
		if (ls.size() > 0) {
			Map<String, Customer> map = new HashMap<>();
			for (Customer p : ls) {
				map.put(p.getId(), p);
			}
			if (map.size() > 0)
				template.opsForHash().putAll(REDIS_CACHE_VALUE, map);
		}

		System.out.println("get list customer from db");
		return repo.findAll();
	}

	@Override
	public Customer addPass(Customer pass) {
		template.opsForHash().put(REDIS_CACHE_VALUE, pass.getId(), pass);
		return repo.save(pass);
	}

}