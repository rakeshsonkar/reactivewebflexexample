package com.reactiveprogramming.reactive.example.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.reactiveprogramming.reactive.example.controller.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {

	private static void  sleepExecution(int i){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Customer> getCustomer(){
		return IntStream.rangeClosed(1, 50)
				.peek(CustomerDao::sleepExecution)
				.peek(i->System.out.println("processing count : "+ i))
				.mapToObj(i->new Customer(i,"cusromer"+i))
				.collect(Collectors.toList());
	}
	
	public Flux<Customer> getCustomerFlux(){
		return Flux.range(1, 50)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("processing count : "+ i))
				.map(i->new Customer(i,"cusromer"+i));
				
	}
}
