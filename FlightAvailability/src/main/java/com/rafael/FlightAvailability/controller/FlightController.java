package com.rafael.FlightAvailability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.FlightAvailability.dtos.ResponseDTO;
import com.rafael.FlightAvailability.entity.Flight;
import com.rafael.FlightAvailability.services.FlightService;

@Controller
@RequestMapping("/flights/check-availability")
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> checkAvilability(@RequestBody Flight flightId) {
		ResponseDTO response = service.flightAvaliable(flightId);
		return ResponseEntity.ok(response);
	}

}
