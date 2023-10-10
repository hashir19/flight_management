package com.hashir.flightmanagement.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashir.flightmanagement.entities.Flight;
import com.hashir.flightmanagement.entities.Passenger;
import com.hashir.flightmanagement.entities.Reservation;
import com.hashir.flightmanagement.entities.User;
import com.hashir.flightmanagement.exceptions.FlightNotFoundException;
import com.hashir.flightmanagement.exceptions.ReservationNotFoundException;
import com.hashir.flightmanagement.exceptions.UserNotFoundException;
import com.hashir.flightmanagement.model.ReservationModel;
import com.hashir.flightmanagement.repos.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ReservationService.class);

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private FlightService flightService;
	

	
	@Autowired
	private UserService userService;
	

	@Transactional
	public Reservation makeReservation(ReservationModel reservationModel) throws UserNotFoundException, FlightNotFoundException {
		Flight flight=flightService.searchFlightById(reservationModel.getFlightId());
		LOGGER.info("Flight: "+flight);
		List<Passenger> passengerList= reservationModel.getPassengerList();
		LOGGER.info("List of Passengers: " +passengerList);
		User user=userService.getUser(reservationModel.getUserId());
		LOGGER.info("User: "+user);
		//userService need to be done
		int noOfSeatsBusiness=reservationModel.getNoOfSeatsBusiness();
		int noOfSeatsEconomy=reservationModel.getNoOfSeatsEconomy();
		double totalFare=((noOfSeatsBusiness*flight.getFareBusiness())+(0.12*flight.getFareBusiness()))
				+((noOfSeatsEconomy*flight.getFareEconomy())+(0.05*flight.getFareEconomy()));
		LOGGER.info("Total fare: " + totalFare);
		Reservation reservation= new Reservation();
		reservation.setFlight(flight);
		reservation.setUser(user);
		reservation.setPassengersList(passengerList);
		reservation.setDepartureDate(reservationModel.getDepartureDate());
		reservation.setTotalFare(totalFare);
		
		return reservationRepository.save(reservation);
	}
	
	public Reservation getReservationById(long reservationId) throws ReservationNotFoundException {
		Reservation reservation=reservationRepository.findById(reservationId).orElse(null);
		if(reservation==null) {
			LOGGER.error("Invalid Reservation Id");
			throw new ReservationNotFoundException("No Reservation found for id: "+reservationId);
		}
		LOGGER.info("Reservation Found: "+reservation);
		return reservation;
		
	}
	
	public List<Reservation> getReservations() {
		List<Reservation> reservationList=reservationRepository.findAll();
		LOGGER.info("No of Reservations: "+reservationList.size());
		return reservationList;
		
	}
	
	public List<Reservation> getReservationsByUserId(String userId){
		List<Reservation> list=reservationRepository.findByUserId(userId);
		return list;
	}
	
	public void cancelReservation(long reservationId) throws ReservationNotFoundException {
		Reservation reservation=getReservationById(reservationId);
		if(reservation==null) {
			LOGGER.error("Invalid Reservation Id");
			throw new ReservationNotFoundException("No Reservation found for id: "+reservationId);
		}
		reservationRepository.delete(reservation);
		LOGGER.info("Reservation Cancelled against reservation Id :"+ reservationId);
	}
}
