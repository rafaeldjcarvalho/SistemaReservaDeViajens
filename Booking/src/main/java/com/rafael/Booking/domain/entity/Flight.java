package com.rafael.Booking.domain.entity;

import java.time.LocalDateTime;

import com.rafael.Booking.dtos.FlightDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String origin;
	private String destination;
	private LocalDateTime departure;
	private int totalSeats;
	
	public Flight(FlightDTO data) {
		this.setOrigin(data.origin());
		this.setDestination(data.destination());
		this.setDeparture(data.departure());
		this.setTotalSeats(data.totalSeats());
	}
}
