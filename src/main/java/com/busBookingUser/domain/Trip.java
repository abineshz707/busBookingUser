package com.busBookingUser.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Trip {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="tripId", nullable=false, updatable=false)
private Long tripId;

public Long getTripId() {
	return tripId;
}

private String departure;


private String arrival;

@ManyToOne
@JoinColumn(name="bus_id")
@JsonIgnore
private Bus bus;

private String availableSeats;

@OneToMany(mappedBy="trip", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
@JsonIgnore
private List<Booking> bookings;


public String getDeparture() {
	return departure;
}

public void setDeparture(String departure) {
	this.departure = departure;
}

public String getArrival() {
	return arrival;
}

public void setArrival(String arrival) {
	this.arrival = arrival;
}

/*
public String getTravelsName() {
	return travelsName;
}

public void setTravelsName(String travelsName) {
	this.travelsName = travelsName;
}*/

public Bus getBus() {
	return bus;
}

public void setBus(Bus bus) {
	this.bus = bus;
}
/*
public String getTotalSeats() {
	return totalSeats;
}

public void setTotalSeats(String totalSeats) {
	this.totalSeats = totalSeats;
}
*/
public String getAvailableSeats() {
	return availableSeats;
}

public void setAvailableSeats(String availableSeats) {
	this.availableSeats = availableSeats;
}

public List<Booking> getBookings() {
	return bookings;
}

public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}




}
