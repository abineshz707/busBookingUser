package com.busBookingUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busBookingUser.domain.Trip;
import com.busBookingUser.service.TripService;

@Controller
public class TripController {

@Autowired
TripService tripService;

@RequestMapping("/trip")
public String findTrips(Model model) {
	
List<Trip> trips = tripService.findAll();
model.addAttribute("trips",trips);
return "trip";
}
	
}
