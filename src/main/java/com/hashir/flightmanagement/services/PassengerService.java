package com.hashir.flightmanagement.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashir.flightmanagement.entities.Passenger;
import com.hashir.flightmanagement.exceptions.PassengerNotFoundException;
import com.hashir.flightmanagement.repos.PassengerRepository;


@Service
public class PassengerService {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PassengerService.class);
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	public Passenger getPassengerById(long passengerId) throws PassengerNotFoundException {
		Passenger passenger= passengerRepository.findById(passengerId).orElse(null);
		if(passenger==null) {
			LOGGER.error("Invalid Passenger Id: ");
			throw new PassengerNotFoundException("No Passenger Found for id: "+passengerId);
		}
		LOGGER.info("Passenger: "+passenger);
		return passenger;
	}
	
	public List<Passenger> getPassengerList() {
		List<Passenger> passengerList= passengerRepository.findAll();
		LOGGER.info("No of Passengers found: "+passengerList.size());
		return passengerList;
	}

}
