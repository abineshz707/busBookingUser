package com.busBookingUser.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.busBookingUser.domain.UserCustomer;


public interface UserCustomerDao extends CrudRepository<UserCustomer, Long> {
	
	UserCustomer findByUsername(String username);
	UserCustomer findByEmail(String email);
	List<UserCustomer> findAll();
	

}
