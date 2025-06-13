package com.rafael.FlightAvailability.services;

import org.springframework.stereotype.Service;

import com.rafael.FlightAvailability.dtos.ResponseDTO;
import com.rafael.FlightAvailability.entity.Flight;

@Service
public class FlightService {
	
	public ResponseDTO flightAvaliable(Flight flightId) {
		System.out.println(flightId);
		String[] status = {"AVAILABLE", "UNAVAILABLE"};
		int number = (int) (Math.random() * 2); // Gerar 0 ou 1
		ResponseDTO response = new ResponseDTO(status[number], flightId.getFlightId());
		return response;
	}
}
