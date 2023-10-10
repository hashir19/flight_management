package com.hashir.flightmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hashir.flightmanagement.entities.Reservation;
import com.hashir.flightmanagement.exceptions.FlightNotFoundException;
import com.hashir.flightmanagement.exceptions.ReservationNotFoundException;
import com.hashir.flightmanagement.exceptions.UserNotFoundException;
import com.hashir.flightmanagement.model.ReservationModel;
import com.hashir.flightmanagement.services.ReservationService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ReservationController {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationService;
	

	@PostMapping("/makereservation")
	public Reservation makeReservation(@RequestBody ReservationModel reservationModel) throws UserNotFoundException, FlightNotFoundException 
	{
		LOGGER.info("Inside makeReservation()");
		Reservation reservation= reservationService.makeReservation(reservationModel);
		return reservation;
	}
	
	@GetMapping("/getreservationbyid/{reservationid}")
	public Reservation getReservationById(@PathVariable("reservationid") long reservationId) throws ReservationNotFoundException {
		Reservation reservation= reservationService.getReservationById(reservationId);
		LOGGER.error("reservation not found");
		return reservation;
	}
	
	@GetMapping("/getreservations")
	public List<Reservation> getReservation() {
		List<Reservation> reservationList= reservationService.getReservations();
		return reservationList;
	}
	
	@GetMapping("/getreservationsbyuserid/{uid}")
	public List<Reservation> getReservationByUserId(@PathVariable("uid") String userId) {
		List<Reservation> reservationList= reservationService.getReservationsByUserId(userId);
		return reservationList;
	}
	
	
	@DeleteMapping("/cancelreservation/{reservationid}")
	public void cancelReservation(@PathVariable("reservationid") long reservationId) throws ReservationNotFoundException {
		reservationService.cancelReservation(reservationId);
	}
}
