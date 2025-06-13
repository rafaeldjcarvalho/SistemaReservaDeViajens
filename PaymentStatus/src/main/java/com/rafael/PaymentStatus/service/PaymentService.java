package com.rafael.PaymentStatus.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rafael.PaymentStatus.dtos.PaymentDTO;
import com.rafael.PaymentStatus.entity.Payment;

@Service
public class PaymentService {
	
	public PaymentDTO paymentStatus(String customerId, String flightId) {
		Payment newPayment = new Payment();
		newPayment.setCustomerId(customerId);
		newPayment.setFlightId(flightId);
		String[] status = {"PAID", "PENDENT", "FAILED"};
		int number = (int) (Math.random() * 3);
		newPayment.setStatus(status[number]);
		newPayment.setPaymentData(LocalDateTime.now());
		
		return new PaymentDTO(newPayment.getStatus(), newPayment.getPaymentData());
	}

}
