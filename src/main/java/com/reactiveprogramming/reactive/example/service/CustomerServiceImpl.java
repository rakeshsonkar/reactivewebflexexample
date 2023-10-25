package com.reactiveprogramming.reactive.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactiveprogramming.reactive.example.controller.dto.Customer;
import com.reactiveprogramming.reactive.example.dao.CustomerDao;

import reactor.core.publisher.Flux;

@Service
public class CustomerServiceImpl {
	@Autowired
	private CustomerDao dao;
	
	public List<Customer> loadAllCustomers(){
		long start = System.currentTimeMillis();
		List<Customer> customers= dao.getCustomer();
		long end = System.currentTimeMillis();
		System.out.println("Total exection time : "+ (end - start));
		return customers;
	}
	
	public Flux<Customer> loadAllCustomersFlux(){
		long start = System.currentTimeMillis();
		Flux<Customer> customers= dao.getCustomerFlux();
		long end = System.currentTimeMillis();
		System.out.println("Total exection time : "+ (end - start));
		return customers;
	}
}
