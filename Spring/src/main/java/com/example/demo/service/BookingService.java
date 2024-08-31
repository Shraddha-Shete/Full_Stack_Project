package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.BookingReceipt;
import com.example.demo.entity.Booking;

public interface BookingService {
	BookingReceipt bookHotel(Booking booking);
	List<Booking> getAllBookings() ;
	List<Booking> findByHotel(int hotelId);
	List<Booking> findByEmail(String guestEmail);
}
