package com.rafael.PaymentStatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.PaymentStatus.dtos.PaymentDTO;
import com.rafael.PaymentStatus.entity.Payment;
import com.rafael.PaymentStatus.service.PaymentService;

@Controller
@RequestMapping("/payment/status")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@PostMapping
	public ResponseEntity<PaymentDTO> paymentStatusAvailable(@RequestBody Payment data) {
		PaymentDTO response = service.paymentStatus(data.getCustomerId(), data.getFlightId());
		return ResponseEntity.ok(response);
	}
}
