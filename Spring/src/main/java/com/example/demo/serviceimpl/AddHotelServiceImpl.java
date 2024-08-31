package com.example.demo.serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AddHotelDto;
import com.example.demo.entity.AddHotel;
import com.example.demo.entity.Manager;
import com.example.demo.repository.AddHotelRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.AddHotelService;
@Service
public class AddHotelServiceImpl implements AddHotelService {
	@Autowired
	AddHotelRepository addHotelRepository;
	@Autowired
	ManagerRepository managerRepository;
	
	private final String imageDir = "C:\\Users\\Shraddha\\Desktop\\Class\\Hotel Booking System\\Project Images";

	@Override
    public AddHotel saveHotel(AddHotelDto addHotelDto, MultipartFile img1, MultipartFile img2, MultipartFile img3)
            throws IOException {
        AddHotel addHotel = new AddHotel();
        addHotel.setHotelName(addHotelDto.getHotelName());
        addHotel.setLocation(addHotelDto.getLocation());
        addHotel.setHotelDescription(addHotelDto.getHotelDescription());

        // Fetch manager by first name
        Manager manager = managerRepository.findByFirstName(addHotelDto.getHotelAdmin().split(" ")[0]);
        if (manager == null) {
            throw new RuntimeException("Manager not found");
        }
        addHotel.setHotelAdmin(manager.getFirstName() + " " + manager.getLastName());
        addHotel.setManager(manager);

        addHotel.setEmail(addHotelDto.getEmail());
        addHotel.setHotelRoom(addHotelDto.getHotelRoom());
        addHotel.setPricePerDay(addHotelDto.getPricePerDay());
        addHotel.setStreet(addHotelDto.getStreet());
        addHotel.setPinCode(addHotelDto.getPinCode());

        // Save images
        if (!img1.isEmpty()) {
            String imageName1 = img1.getOriginalFilename();
            Path imagePath = Paths.get(imageDir, imageName1);
            Files.copy(img1.getInputStream(), imagePath);
            addHotel.setImg1(imagePath.toString());
        }
        if (!img2.isEmpty()) {
            String imageName2 = img2.getOriginalFilename();
            Path imagePath2 = Paths.get(imageDir, imageName2);
            Files.copy(img2.getInputStream(), imagePath2);
            addHotel.setImg2(imagePath2.toString());
        }
        if (!img3.isEmpty()) {
            String imageName3 = img3.getOriginalFilename();
            Path imagePath3 = Paths.get(imageDir, imageName3);
            Files.copy(img3.getInputStream(), imagePath3);
            addHotel.setImg3(imagePath3.toString());
        }

        return addHotelRepository.save(addHotel);
    }
	@Override
	public AddHotel findbyId(int id) {
		return addHotelRepository.findById(id).orElse(null);
	}

	@Override
	public List<AddHotel> findAll() {
		return addHotelRepository.findAll();
	}
	@Override
	public AddHotel findByHotelName(String hotelName) {
		return addHotelRepository.findByhotelName(hotelName);
	}
	
	
	
}




