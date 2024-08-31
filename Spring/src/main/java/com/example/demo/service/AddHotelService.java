package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AddHotelDto;
import com.example.demo.entity.AddHotel;

public interface AddHotelService {
	public AddHotel saveHotel(AddHotelDto addHotelDto, MultipartFile img1, MultipartFile img2, MultipartFile img3) throws IOException;
	public AddHotel findbyId(int id);
	public List<AddHotel> findAll();
	public AddHotel findByHotelName(String hotelName);

}
