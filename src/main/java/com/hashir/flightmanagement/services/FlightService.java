package com.hashir.flightmanagement.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashir.flightmanagement.entities.Flight;
import com.hashir.flightmanagement.exceptions.FlightNotFoundException;
import com.hashir.flightmanagement.repos.FlightRepository;

@Service
public class FlightService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightService.class);
	
	@Autowired
	private FlightRepository flightRepository;

	
	public Flight addFlight(Flight flight) {
		
		Flight savedFlight = flightRepository.save(flight);
		
		LOGGER.info("Flight added");
		return savedFlight;
		
	}
	
	public Flight searchFlightById(String flightId) throws FlightNotFoundException {
		Flight flight=flightRepository.findById(flightId).orElse(null);
		if(flight==null) {
			LOGGER.error("Invalid Flight Id");
			throw new FlightNotFoundException("Flight not found for Flight Id: "+flightId);
		}
		LOGGER.info("Flight: "+flight);
		return flight;
	}
	
	public List<Flight> searchFlights(String departureCity, String arrivalCity) {
		List<Flight> flightList= flightRepository.findFlights(departureCity, arrivalCity);
		LOGGER.info("No of Flights found: "+flightList.size());
		return flightList;
	}
	
	public List<Flight> searchAllFlights(){
		return flightRepository.findAll();
	}

}
