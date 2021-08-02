package com.busBookingUser.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking {
	
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name="bookingId", nullable= false, updatable=false)
private Long bookingId;

@ManyToOne
@JoinColumn(name="user_id")
@JsonIgnore
private UserCustomer customer;

private String travelsName;
private String busName;

@ManyToOne
@JoinColumn(name="trip_id")
@JsonIgnore
private Trip trip;
private String paidBy;
private boolean status;


public Long getBookingId() {
	return bookingId;
}
public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}

public UserCustomer getCustomer() {
	return customer;
}
public void setCustomer(UserCustomer customer) {
	this.customer = customer;
}
public String getTravelsName() {
	return travelsName;
}
public void setTravelsName(String travelsName) {
	this.travelsName = travelsName;
}
public String getBusName() {
	return busName;
}
public void setBusName(String busName) {
	this.busName = busName;
}
public Trip getTrip() {
	return trip;
}
public void setTrip(Trip trip) {
	this.trip = trip;
}
public String getPaidBy() {
	return paidBy;
}
public void setPaidBy(String paidBy) {
	this.paidBy = paidBy;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}



}
