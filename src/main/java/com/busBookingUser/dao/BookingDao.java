package com.busBookingUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.busBookingUser.domain.Booking;
import com.busBookingUser.domain.Trip;
import com.busBookingUser.domain.UserCustomer;

public interface BookingDao extends CrudRepository<Booking, Long>{
	List<Booking> findByCustomer(UserCustomer userCustomer);
	List<Booking> findAll();
	
	Booking save(Booking booking);
	
}
