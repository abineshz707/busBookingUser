package com.busBookingUser.service;

import java.util.List;


import com.busBookingUser.domain.Booking;
import com.busBookingUser.domain.UserCustomer;

public interface BookingService {

	
	List<Booking> findByCustomer(UserCustomer userCustomer);
	Booking save(Booking booking);
}
