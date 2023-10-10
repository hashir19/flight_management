package com.hashir.flightmanagement.model;

import java.util.Date;
import java.util.List;

import com.hashir.flightmanagement.entities.Passenger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ReservationModel {
	
	private String userId;
	private List<Passenger> passengerList;
	private String flightId;
	private Date departureDate;
	private int noOfSeatsBusiness;
	private int noOfSeatsEconomy;


}
