package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingReceipt;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@CrossOrigin("*")
public class BookingController {
	@Autowired
    BookingService bookingService;

    @PostMapping("/bookHotel")
    public BookingReceipt bookHotel(@RequestBody Booking booking) {
    	System.out.println(booking);
        return bookingService.bookHotel(booking);
    }

    @GetMapping("/listOfBooking")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    @GetMapping("/booking/{id}")
    public List<Booking> getBookingByHotelId(@PathVariable int id){
    	return bookingService.findByHotel(id);
    }
    
    @GetMapping("UserBooking/{guestEmail}")
    public List<Booking> findByEmail(@PathVariable String guestEmail){
    	return bookingService.findByEmail(guestEmail);
    }
}
