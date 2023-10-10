package com.hashir.flightmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashir.flightmanagement.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
