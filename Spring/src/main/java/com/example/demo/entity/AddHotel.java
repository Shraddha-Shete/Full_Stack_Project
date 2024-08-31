package com.example.demo.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AddHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String hotelName;
    String location;
    String hotelDescription;
    String hotelAdmin; 
    
    @OneToOne
    @JoinColumn(name = "Manager_id")
    @JsonBackReference
    private Manager manager;
    
    String email;
    int pricePerDay;
    int hotelRoom;
    String street;
    int pinCode;
    String img1;
    String img2;
    String img3;
	public AddHotel() {
		
	}
	
	
	public AddHotel(int id, String hotelName, String location, String hotelDescription, String hotelAdmin,
			Manager manager, String email, int pricePerDay, int hotelRoom, String street, int pinCode, String img1,
			String img2, String img3) {
		
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.hotelDescription = hotelDescription;
		this.hotelAdmin = hotelAdmin;
		this.manager = manager;
		this.email = email;
		this.pricePerDay = pricePerDay;
		this.hotelRoom = hotelRoom;
		this.street = street;
		this.pinCode = pinCode;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHotelDescription() {
		return hotelDescription;
	}
	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}
	public String getHotelAdmin() {
		return hotelAdmin;
	}
	public void setHotelAdmin(String hotelAdmin) {
		this.hotelAdmin = hotelAdmin;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public int getHotelRoom() {
		return hotelRoom;
	}
	public void setHotelRoom(int hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	
    
    
    
    
    
    
}