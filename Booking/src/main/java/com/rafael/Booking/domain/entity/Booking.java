package com.rafael.Booking.domain.entity;

import java.time.LocalDate;

import com.rafael.Booking.domain.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name= "flight_id")
	private Flight flight;
	
	private LocalDate bookingDate;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	private String reason;
	
	private String ticketCode;
}
