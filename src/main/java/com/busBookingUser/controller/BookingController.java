package com.busBookingUser.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.busBookingUser.domain.Booking;
import com.busBookingUser.domain.Trip;
import com.busBookingUser.domain.UserCustomer;
import com.busBookingUser.service.BookingService;
import com.busBookingUser.service.TripService;
import com.busBookingUser.service.UserCustomerService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
@Autowired
BookingService bookingService;

@Autowired
UserCustomerService userCustomerService;

@Autowired
TripService tripService;

@RequestMapping("/myBooking")
public String myBooking(Principal principal,Model model) {
UserCustomer userCustomer = userCustomerService.findByUsername(principal.getName());
List<Booking> bookings= bookingService.findByCustomer(userCustomer);
model.addAttribute("bookings",bookings);
return "myBooking";

}

@RequestMapping(value="/book", method=RequestMethod.GET)
public String bookGet(@RequestParam("tripId") Long tripId, Model model) {
	Trip selectedTrip = tripService.findById(tripId);
	Long mainId=tripId;
	model.addAttribute("mainId",mainId);
	model.addAttribute("selectedTrip",selectedTrip);
	model.addAttribute("paidBy","");
	return "bookingPage";
}

@RequestMapping(value="/book", method= RequestMethod.POST)
public String bookPost(@ModelAttribute("mainId") Long mainId, 
		@ModelAttribute("paidBy") String paidBy, Principal principal) {
	
Booking booking =new Booking();
Trip trip = tripService.findById(mainId);
Long seats=Long.valueOf(trip.getAvailableSeats())-1;
trip.setAvailableSeats(String.valueOf(seats));
tripService.save(trip);
UserCustomer userCustomer = userCustomerService.findByUsername(principal.getName());
booking.setCustomer(userCustomer);
booking.setPaidBy(paidBy);	
booking.setTrip(trip);
booking.setStatus(true);
booking.setBusName(trip.getBus().getBusName());
booking.setTravelsName(trip.getBus().getTravels().getTravelsName());
//finally
bookingService.save(booking);
return "redirect:/trip";
}

}
