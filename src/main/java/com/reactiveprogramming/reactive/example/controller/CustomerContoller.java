package com.reactiveprogramming.reactive.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveprogramming.reactive.example.controller.dto.Customer;
import com.reactiveprogramming.reactive.example.service.CustomerServiceImpl;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerContoller {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("/test")
	public List<Customer> getAllUser(){
		return customerService.loadAllCustomers();
	}
	@GetMapping(value="/testStream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllUserStream(){
		return customerService.loadAllCustomersFlux();
	}

}
