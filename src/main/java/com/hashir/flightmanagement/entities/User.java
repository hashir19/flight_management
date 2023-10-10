package com.hashir.flightmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//import javax.persistence.Column;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@Column(name="user_id" ,length=30)
	private String userId;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String password;
	
	

}
