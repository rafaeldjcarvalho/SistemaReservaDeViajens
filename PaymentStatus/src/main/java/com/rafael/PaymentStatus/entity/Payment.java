package com.rafael.PaymentStatus.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private String customerId;
	private String flightId;
	private String status;
	private LocalDateTime paymentData;

}
