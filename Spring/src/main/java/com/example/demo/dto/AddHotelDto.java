package com.example.demo.dto;

public class AddHotelDto {
	
	int id;
	String hotelName;
	String location;
	String hotelDescription;
	String hotelAdmin;
	String email;
	int pricePerDay;
	int hotelRoom;
	String street;
	int pinCode;
	public AddHotelDto() {
		
	}
	public AddHotelDto(int id, String hotelName, String location, String hotelDescription, String hotelAdmin,
			String email, int pricePerDay, int hotelRoom, String street, int pinCode) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.hotelDescription = hotelDescription;
		this.hotelAdmin = hotelAdmin;
		this.email = email;
		this.pricePerDay = pricePerDay;
		this.hotelRoom = hotelRoom;
		this.street = street;
		this.pinCode = pinCode;
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
	@Override
	public String toString() {
		return "AddHotelDto [id=" + id + ", hotelName=" + hotelName + ", location=" + location + ", hotelDescription="
				+ hotelDescription + ", hotelAdmin=" + hotelAdmin + ", email=" + email + ", pricePerDay=" + pricePerDay
				+ ", hotelRoom=" + hotelRoom + ", street=" + street + ", pinCode=" + pinCode + "]";
	}
	
	
	
	

}
