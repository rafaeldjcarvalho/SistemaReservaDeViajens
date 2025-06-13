package com.rafael.Booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.Booking.domain.entity.Flight;
import com.rafael.Booking.dtos.FlightDTO;
import com.rafael.Booking.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository repository;
	
	public List<Flight> getAllFlights() {
		return repository.findAll();
	}
	
	public Flight findFlightById(Long id) {
		Flight flight = repository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
		return flight;
	}
	
	public Flight createFlight(FlightDTO data) {
		Flight newFlight = new Flight(data);
		saveFlight(newFlight);
		return newFlight;
	}
	
	public void saveFlight(Flight data) {
		repository.save(data);
	}
}
