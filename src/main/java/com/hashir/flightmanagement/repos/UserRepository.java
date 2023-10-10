package com.hashir.flightmanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashir.flightmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
