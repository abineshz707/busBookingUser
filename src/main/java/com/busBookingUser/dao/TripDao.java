package com.busBookingUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.busBookingUser.domain.Trip;

public interface TripDao extends CrudRepository<Trip, Long> {

	List<Trip> findAll();
	Trip save(Trip trip);
}
