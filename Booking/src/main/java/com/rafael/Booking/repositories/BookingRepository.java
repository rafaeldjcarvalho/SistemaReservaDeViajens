package com.rafael.Booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.Booking.domain.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
