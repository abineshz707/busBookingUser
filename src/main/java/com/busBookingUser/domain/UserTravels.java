package com.busBookingUser.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserTravels implements UserDetails{

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name="userId", nullable=false, updatable=false)
private Long userId;
private String username;
private String firstName;
private String lastName;
private String password;
private String travelsName;


@OneToMany(mappedBy="travels", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
@JsonIgnore
private List<Bus> buses;


public Long getUserId() {
	return userId;
}


public void setUserId(Long userId) {
	this.userId = userId;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getTravelsName() {
	return travelsName;
}


public void setTravelsName(String travelsName) {
	this.travelsName = travelsName;
}


public List<Bus> getBuses() {
	return buses;
}


public void setBuses(List<Bus> buses) {
	this.buses = buses;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}


}
