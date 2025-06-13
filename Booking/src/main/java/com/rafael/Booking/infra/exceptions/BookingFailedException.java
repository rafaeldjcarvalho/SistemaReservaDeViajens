package com.rafael.Booking.infra.exceptions;

import lombok.Getter;

@Getter
public class BookingFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reason;
	
	public BookingFailedException(String message, String reason) {
		super(message);
		this.reason = reason;
	}
}
