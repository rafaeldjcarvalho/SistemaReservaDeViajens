package com.rafael.PaymentStatus.dtos;

import java.time.LocalDateTime;

public record PaymentDTO(
		String status,
		LocalDateTime paymentDate) {}
