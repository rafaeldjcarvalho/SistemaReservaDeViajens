package com.rafael.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.Booking.domain.entity.Customer;
import com.rafael.Booking.dtos.CustomerDTO;
import com.rafael.Booking.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer findUserById(Long id) {
		Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not find"));
		return customer;
	}
	
	public Customer createCustomer(CustomerDTO data) {
		Customer newCustomer = new Customer(data);
		saveCustomer(newCustomer);
		return newCustomer;
	}
	
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	public void saveCustomer(Customer data) {
		repository.save(data);
	}

}
