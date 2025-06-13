package com.rafael.Booking.dtos;

import java.time.LocalDateTime;

public record FlightDTO(
		Long id,
		String origin,
		String destination,
		LocalDateTime departure,
		int totalSeats) {

}
