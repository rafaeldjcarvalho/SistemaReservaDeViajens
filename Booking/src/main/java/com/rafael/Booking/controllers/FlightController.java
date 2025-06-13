package com.rafael.Booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.Booking.domain.entity.Flight;
import com.rafael.Booking.dtos.FlightDTO;
import com.rafael.Booking.services.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@GetMapping
	public ResponseEntity<List<Flight>> getAllFlights() {
		List<Flight> list = service.getAllFlights();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO data) {
		Flight flight = service.createFlight(data);
		return ResponseEntity.ok(flight);
	}

}
