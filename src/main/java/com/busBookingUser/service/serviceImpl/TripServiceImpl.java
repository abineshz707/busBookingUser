package com.busBookingUser.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busBookingUser.dao.TripDao;
import com.busBookingUser.domain.Trip;
import com.busBookingUser.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	
@Autowired
TripDao tripDao;


public List<Trip> findAll() {
	return tripDao.findAll();
}

public Trip findById(Long Id) {
	Optional<Trip> trip =tripDao.findById(Id);
	return trip.get();
}

public Trip save(Trip trip) {
	return tripDao.save(trip);
	
}

}
