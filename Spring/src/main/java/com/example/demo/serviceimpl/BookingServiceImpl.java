package com.example.demo.serviceimpl;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingReceipt;
import com.example.demo.entity.AddHotel;
import com.example.demo.entity.Booking;
import com.example.demo.repository.AddHotelRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AddHotelRepository addHotelRepository;

	@Override
	public BookingReceipt bookHotel(Booking booking) {
		 boolean paymentSuccess = paymentService.processPayment(
		            booking.getCardNumber(), 
		            booking.getCardExpiry(), 
		            booking.getCardCVV(), 
		            booking.getCardName()
		        );

		 if (paymentSuccess) {
		        	AddHotel hotel = addHotelRepository.findById(booking.getHotelId()).get();               
		        	double pricePerDay = hotel.getPricePerDay();
		        	double multiplier = PriceCalculator.getMultiplier(booking.getRoomType());
//		        	long numberOfDays = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
		        	double totalPrice = pricePerDay * multiplier * booking.getNumRooms();

		        	booking.setTotalPrice(totalPrice);
		        	bookingRepository.save(booking);
		        	// Return receipt data
		        	BookingReceipt receipt = new BookingReceipt();
		            receipt.setHotelName(hotel.getHotelName());
		            receipt.setCheckInDate(booking.getCheckInDate());
		            receipt.setCheckOutDate(booking.getCheckOutDate());
		            receipt.setRoomType(booking.getRoomType());
		            receipt.setNumRooms(booking.getNumRooms());
		            receipt.setPricePerDay(pricePerDay);
		            receipt.setTotalAmount(totalPrice);
		            return receipt;
		 } else {
		            throw new RuntimeException("Payment failed");
		        }
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> findByHotel(int hotelId) {
		return bookingRepository.findByHotelId(hotelId);
	}

	@Override
	public List<Booking> findByEmail(String guestEmail) {
		return bookingRepository.findByGuestEmail(guestEmail);
	}

}
