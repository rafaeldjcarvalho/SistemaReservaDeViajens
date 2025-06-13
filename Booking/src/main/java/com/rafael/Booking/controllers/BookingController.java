package com.rafael.Booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafael.Booking.domain.entity.Booking;
import com.rafael.Booking.services.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService service;
	
	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> list = service.getAllBookings();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody Long customerId, @RequestBody Long flightId) {
		Booking booking = service.createBooking(customerId, flightId);
		return ResponseEntity.ok(booking);
	}
}
