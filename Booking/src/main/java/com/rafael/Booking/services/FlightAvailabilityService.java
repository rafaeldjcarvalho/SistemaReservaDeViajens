package com.rafael.Booking.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightAvailabilityService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${app.flightAvailabilityAPI}")
	private String serviceAPI;
	
	public boolean flightAvailability() {
		ResponseEntity<Map> availableResponse = restTemplate.getForEntity(this.serviceAPI, Map.class);
		
		if(availableResponse.getStatusCode() == HttpStatus.OK) {
			String mensagem = (String) availableResponse.getBody().get("status");
			return "AVAILABLE".equals(mensagem);
		} else return false;
	}

}
