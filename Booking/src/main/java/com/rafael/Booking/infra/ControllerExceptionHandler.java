package com.rafael.Booking.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rafael.Booking.dtos.BookingFailed;
import com.rafael.Booking.dtos.ExceptionDTO;
import com.rafael.Booking.infra.exceptions.BookingFailedException;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(BookingFailedException.class)
    public ResponseEntity threatBookingFailedException(BookingFailedException exception) {
    	BookingFailed exceptionDTO = new BookingFailed(exception.getMessage(), exception.getReason());
    	return ResponseEntity.internalServerError().body(exceptionDTO);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity threatGeneralException(RuntimeException exception) {
    	ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
    	return ResponseEntity.internalServerError().body(exceptionDTO);
    }

}
