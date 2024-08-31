package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private int numRooms;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private String specialRequests;

    private String cardNumber;
    private String cardExpiry;
    private String cardCVV;
    private String cardName;
    
    private double totalPrice;
    private int hotelId;
	public Booking() {
		
	}
	
	public Booking(Long id, String checkInDate, String checkOutDate, String roomType, int numRooms, String guestName,
			String guestEmail, String guestPhone, String specialRequests, String cardNumber, String cardExpiry,
			String cardCVV, String cardName, double totalPrice, int hotelId) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.numRooms = numRooms;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.guestPhone = guestPhone;
		this.specialRequests = specialRequests;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardCVV = cardCVV;
		this.cardName = cardName;
		this.totalPrice = totalPrice;
		this.hotelId = hotelId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestPhone() {
		return guestPhone;
	}
	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}
	public String getSpecialRequests() {
		return specialRequests;
	}
	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", roomType="
				+ roomType + ", numRooms=" + numRooms + ", guestName=" + guestName + ", guestEmail=" + guestEmail
				+ ", guestPhone=" + guestPhone + ", specialRequests=" + specialRequests + ", cardNumber=" + cardNumber
				+ ", cardExpiry=" + cardExpiry + ", cardCVV=" + cardCVV + ", cardName=" + cardName + ", totalPrice="
				+ totalPrice + ", hotelId=" + hotelId + "]";
	}
	
    
    
	

}
