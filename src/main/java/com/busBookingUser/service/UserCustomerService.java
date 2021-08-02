package com.busBookingUser.service;

import java.util.List;

import com.busBookingUser.domain.UserCustomer;

public interface UserCustomerService {
	
	UserCustomer findByUsername(String username);

    UserCustomer findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
    
    void save (UserCustomer userCustomer);
    
    UserCustomer createUserCustomer(UserCustomer userCustomer);
    
    UserCustomer saveUserCustomer (UserCustomer userCustomer); 
    
    List<UserCustomer> findUserList();

    //void enableUser (String username);

    //void disableUser (String username);
}

