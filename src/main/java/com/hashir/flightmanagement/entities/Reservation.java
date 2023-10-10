package com.hashir.flightmanagement.entities;

import java.util.Date;

import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reservationId;
	//private Boolean checkedIn;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Passenger> passengersList;
	@ManyToOne
	@JoinColumn(name="fid")
	private Flight flight;
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;
	private double totalFare;

}
