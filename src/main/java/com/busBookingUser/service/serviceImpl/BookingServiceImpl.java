package com.busBookingUser.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busBookingUser.dao.BookingDao;
import com.busBookingUser.domain.Booking;
import com.busBookingUser.domain.UserCustomer;
import com.busBookingUser.service.BookingService;

@Service
@RequestMapping("/booking")
@Transactional
public class BookingServiceImpl implements BookingService{
	
@Autowired
BookingDao bookingDao;


public Booking save(Booking booking) {
	return bookingDao.save(booking);
	
}


public List<Booking> findByCustomer(UserCustomer userCustomer){
	return bookingDao.findByCustomer(userCustomer);
}

}
