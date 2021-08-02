package com.busBookingUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.busBookingUser.domain.UserTravels;

public interface UserTravelsDao extends CrudRepository<UserTravels, Long> {
	
	UserTravels findByUsername(String username);
	List<UserTravels> findAll();

}
