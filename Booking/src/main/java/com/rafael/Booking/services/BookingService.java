package com.rafael.Booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.Booking.domain.entity.Booking;
import com.rafael.Booking.domain.entity.Customer;
import com.rafael.Booking.domain.entity.Flight;
import com.rafael.Booking.domain.enums.BookingStatus;
import com.rafael.Booking.infra.exceptions.BookingFailedException;
import com.rafael.Booking.repositories.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightAvailabilityService availabilityService;
	
	@Autowired
	private PaymentStatusService paymentStatusService;
	
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}
	
	public Booking createBooking(Long customerId, Long flightId) {
		Customer customer = customerService.findUserById(customerId);
		Flight flight = flightService.findFlightById(flightId);
		
		// verificar disponobilidade
		boolean flightAvailability = availabilityService.flightAvailability();
		
		if(!flightAvailability) {
			throw new BookingFailedException("REJECTED", "Flight Unavailable");
		}
		// verificar pagamento
		boolean paymentStatus = paymentStatusService.paymentStatus();
		
		if(!paymentStatus) {
			throw new BookingFailedException("REJECTED", "Payment not paid");
		}
	
		Booking newBooking = new Booking();
		
		newBooking.setCustomer(customer);
		newBooking.setFlight(flight);
		newBooking.setBookingDate(LocalDate.now());
		newBooking.setReason(null);
		newBooking.setStatus(BookingStatus.CONFIRMED);
		newBooking.setTicketCode(null);
		
		saveBooking(newBooking);
		return newBooking;
		
	}
	
	public void saveBooking(Booking data) {
		repository.save(data);
	}

}
