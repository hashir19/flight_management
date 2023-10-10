package com.hashir.flightmanagement.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hashir.flightmanagement.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query(value = "SELECT r from Reservation r where r.user.userId=?1")
	List<Reservation> findByUserId(String userId);

}
