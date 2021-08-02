package com.busBookingUser.service.serviceImpl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.busBookingUser.dao.UserCustomerDao;
import com.busBookingUser.domain.UserCustomer;
import com.busBookingUser.service.UserCustomerService;

@Service
@Transactional
public class UserCustomerServiceImpl implements UserCustomerService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserCustomerService.class);
	
	@Autowired
	private UserCustomerDao userCustomerDao;
	

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    
	public void save(UserCustomer userCustomer) {
        userCustomerDao.save(userCustomer);
    }

    public UserCustomer findByUsername(String userCustomername) {
        return userCustomerDao.findByUsername(userCustomername);
    }

    public UserCustomer findByEmail(String email) {
        return userCustomerDao.findByEmail(email);
    }
    
    
    public UserCustomer createUserCustomer(UserCustomer userCustomer) {
        UserCustomer localUserCustomer = userCustomerDao.findByUsername(userCustomer.getUsername());

        if (localUserCustomer != null) {
            LOG.info("UserCustomer with userCustomername {} already exist. Nothing will be done. ", userCustomer.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(userCustomer.getPassword());
            userCustomer.setPassword(encryptedPassword);

                       

            
            localUserCustomer = userCustomerDao.save(userCustomer);
        }

        return localUserCustomer;
    }
    
    public boolean checkUserExists(String userCustomername, String email){
        if (checkUsernameExists(userCustomername) || checkEmailExists(userCustomername)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String userCustomername) {
        if (null != findByUsername(userCustomername)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public UserCustomer saveUserCustomer (UserCustomer userCustomer) {
        return userCustomerDao.save(userCustomer);
    }
    
    public List<UserCustomer> findUserList() {
        return userCustomerDao.findAll();
    }
    
}