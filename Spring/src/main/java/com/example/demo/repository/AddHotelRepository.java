package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AddHotel;

public interface AddHotelRepository extends JpaRepository<AddHotel, Integer> {
	AddHotel findByhotelAdmin(String firstName);
	AddHotel findByhotelName(String hotelName);

}
