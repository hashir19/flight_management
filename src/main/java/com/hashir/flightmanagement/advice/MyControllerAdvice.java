package com.hashir.flightmanagement.advice;


	import org.springframework.http.HttpStatus;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.ControllerAdvice;

	import org.springframework.web.bind.annotation.ExceptionHandler;

	import org.springframework.web.context.request.WebRequest;

	import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hashir.flightmanagement.exceptions.FlightNotFoundException;
import com.hashir.flightmanagement.exceptions.ReservationNotFoundException;
import com.hashir.flightmanagement.exceptions.UserNotFoundException;
import com.hashir.flightmanagement.model.ApiResponseError;


	@ControllerAdvice

	public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ApiResponseError> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

	ApiResponseError obj = new ApiResponseError();

	obj.setMessage(ex.getMessage());

	obj.setStatusCode("404");

	obj.setUrl(request.getContextPath());

	return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);

	}
	
	

	@ExceptionHandler(value = FlightNotFoundException.class)

	public ResponseEntity<ApiResponseError> handleFlightNotFoundException(FlightNotFoundException ex, WebRequest request) {

	ApiResponseError obj = new ApiResponseError();

	obj.setMessage(ex.getMessage());

	obj.setStatusCode("404");

	obj.setUrl(request.getContextPath());

	return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(value = ReservationNotFoundException.class)

	public ResponseEntity<ApiResponseError> handleReservationNotFoundException(ReservationNotFoundException ex, WebRequest request) {

	ApiResponseError obj = new ApiResponseError();

	obj.setMessage(ex.getMessage());

	obj.setStatusCode("404");

	obj.setUrl(request.getContextPath());

	return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);

	}
}
