package com.hashir.flightmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hashir.flightmanagement.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

	@Query(value = "SELECT f FROM Flight f WHERE f.departureCity = ?1 and f.arrivalCity=?2")
	List<Flight> findFlights(String departureCity, String arrivalCity);

}
