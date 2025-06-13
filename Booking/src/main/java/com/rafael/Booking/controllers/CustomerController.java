package com.rafael.Booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.Booking.domain.entity.Customer;
import com.rafael.Booking.dtos.CustomerDTO;
import com.rafael.Booking.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = service.getAllCustomers();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO data) {
		Customer customer = service.createCustomer(data);
		return ResponseEntity.ok(customer);
		
	}

}
