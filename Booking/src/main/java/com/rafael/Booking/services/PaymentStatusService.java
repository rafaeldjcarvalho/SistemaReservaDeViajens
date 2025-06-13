package com.rafael.Booking.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentStatusService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${app.paymentStatusAPI}")
	private String paymentStatusAPI;
	
	public boolean paymentStatus() {
		ResponseEntity<Map> statusResponse = restTemplate.getForEntity(this.paymentStatusAPI, Map.class);
		
		if(statusResponse.getStatusCode() == HttpStatus.OK) {
			String mensagem = (String) statusResponse.getBody().get("status");
			return "PAID".equals(mensagem);
		} else return false;
	}

}
