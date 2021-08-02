package com.busBookingUser.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.busBookingUser.domain.UserCustomer;
import com.busBookingUser.service.UserCustomerService;

@Controller
public class HomeController {

@Autowired
UserCustomerService userCustomerService;
	
@RequestMapping("/")
public String home() {
	return "redirect:/index";
}
	
@RequestMapping("/index")
public String index() {
     return "index";
}

@RequestMapping(value="/signup", method = RequestMethod.GET)
public String signupGet(Model model)
{
	UserCustomer userCustomer =new UserCustomer();
	model.addAttribute(userCustomer);
	return "signup";
	
}

@RequestMapping(value="/signup", method= RequestMethod.POST)
public String signupPost(@ModelAttribute("userCustomer") UserCustomer userCustomer, Model model) {
	if(userCustomerService.checkUserExists(userCustomer.getUsername(), userCustomer.getEmail()))  {

        if (userCustomerService.checkEmailExists(userCustomer.getEmail())) {
            model.addAttribute("emailExists", true);
        }

        if (userCustomerService.checkUsernameExists(userCustomer.getUsername())) {
            model.addAttribute("usernameExists", true);
        }

        return "signup";
	}
	else {
   	 
       userCustomerService.createUserCustomer(userCustomer);

       return "redirect:/";
   }
}
	
@RequestMapping(value="/userCustomerFront")
public String userCutomerFront(Principal principal, Model model)
{
	UserCustomer userCustomer= userCustomerService.findByUsername(principal.getName());
	model.addAttribute("userCustomer", userCustomer);
	return "userCustomerFront";
	
}

	


}
