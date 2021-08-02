package com.busBookingUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.busBookingUser.domain.Bus;
import com.busBookingUser.domain.UserTravels;

public interface BusDao extends CrudRepository<Bus, Long>{
	List<Bus> findAll();
	List<Bus> findByTravels(UserTravels userTravels);

}
