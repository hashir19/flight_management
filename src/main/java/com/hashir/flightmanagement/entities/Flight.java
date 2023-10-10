package com.hashir.flightmanagement.entities;



//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Flight{
	

	@Id
	@Column(name="flightId", length = 20)
	private String flightId;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private int noOfSeatsBusiness;
	private int noOfSeatsEconomy;
	private int fareBusiness;
	private int fareEconomy;
	


	
}
