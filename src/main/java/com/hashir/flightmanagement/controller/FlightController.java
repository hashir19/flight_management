package com.hashir.flightmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hashir.flightmanagement.entities.Flight;
import com.hashir.flightmanagement.exceptions.FlightNotFoundException;
import com.hashir.flightmanagement.services.FlightService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class FlightController {
	
	//private static final Logger logger= LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/addflight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}
	
	@GetMapping("/getflightbyid/{flightid}")
	public Flight getFlight(@PathVariable("flightid") String flightId) throws FlightNotFoundException {
		//logger.error("Invalid FlightNotFoundException Id");
		return flightService.searchFlightById(flightId);
	}
	
	@GetMapping("/getflights/{departureCity}/{arrivalCity}")
	public List<Flight> getFlight(@PathVariable String departureCity,@PathVariable String arrivalCity) {
		List<Flight> flightList= flightService.searchFlights(departureCity, arrivalCity);
		//logger.info("Fetched flight list");
		return flightList;
	}
	
	@GetMapping("/getallflights")
	public List<Flight> getAllFlights(){
		return flightService.searchAllFlights();
	}

}
