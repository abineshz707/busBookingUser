package com.busBookingUser.service;

import java.util.List;


import com.busBookingUser.domain.Trip;

public interface TripService {
	
	List<Trip> findAll();
	Trip findById(Long Id);
	Trip save(Trip trip);

}
