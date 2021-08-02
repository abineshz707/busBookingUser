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
public class Bus {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="busId", nullable=false, updatable=false)
private Long busId;

@ManyToOne
@JoinColumn(name="user_id")
@JsonIgnore
private UserTravels travels;
private String busName;
private String numberPlate;
private String amenities;
private String totalSeats;

@OneToMany(mappedBy="bus", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
@JsonIgnore
private List<Trip> trips;

public Long getBusId() {
	return busId;
}

public void setBusId(Long busId) {
	this.busId = busId;
}

public UserTravels getTravels() {
	return travels;
}

public void setTravels(UserTravels travels) {
	this.travels = travels;
}

public String getBusName() {
	return busName;
}

public void setBusName(String busName) {
	this.busName = busName;
}

public String getNumberPlate() {
	return numberPlate;
}

public void setNumberPlate(String numberPlate) {
	this.numberPlate = numberPlate;
}

public String getAmenities() {
	return amenities;
}

public void setAmenities(String amenities) {
	this.amenities = amenities;
}

public String getTotalSeats() {
	return totalSeats;
}

public void setTotalSeats(String totalSeats) {
	this.totalSeats = totalSeats;
}

public List<Trip> getTrips() {
	return trips;
}

public void setTrips(List<Trip> trips) {
	this.trips = trips;
}


}
