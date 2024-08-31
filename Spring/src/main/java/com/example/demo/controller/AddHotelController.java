package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AddHotelDto;
import com.example.demo.entity.AddHotel;
import com.example.demo.service.AddHotelService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
public class AddHotelController {
	@Autowired
	AddHotelService addHotelService;
	
	@Autowired
	 ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("/addHotel")
    public ResponseEntity<AddHotel> addHotel(@RequestPart("addHotel") String addHotelDtoJson,
                                             @RequestPart("image1") MultipartFile image1,
                                             @RequestPart("image2") MultipartFile image2,
                                             @RequestPart("image3") MultipartFile image3) {
        try {
            AddHotelDto addHotelDto = objectMapper.readValue(addHotelDtoJson, AddHotelDto.class);
            AddHotel savedHotel = addHotelService.saveHotel(addHotelDto, image1, image2, image3);
            return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
//	@GetMapping("find/{id}")
//	public ResponseEntity<List<Resource>> findHotelById(@PathVariable("id") int id) throws IOException {
//		AddHotel hotel= addHotelService.findbyId(id);
//		List<Resource> resources = new ArrayList<>();
//		if (hotel != null) {
//            if (hotel.getImg1() != null) {
//                Path filePath1 = Paths.get(hotel.getImg1());
//                Resource resource1 = new UrlResource(filePath1.toUri());
//                resources.add(resource1);
//            }
//
//            if (hotel.getImg2() != null) {
//                Path filePath2 = Paths.get(hotel.getImg2());
//                Resource resource2 = new UrlResource(filePath2.toUri());
//                resources.add(resource2);
//            }
//
//            if (hotel.getImg3() != null) {
//                Path filePath3 = Paths.get(hotel.getImg3());
//                Resource resource3 = new UrlResource(filePath3.toUri());
//                resources.add(resource3);
//            }
//            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment").body(resources);
//            } else {
//                // Handle hotel not found
//                return ResponseEntity.notFound().build();
//            }
//		//return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filepath1=\"" + resource.getFilename()+"\"").body(resource);
//	}
	

//	private final Path rootLocation = Paths.get("C:\\\\Users\\\\Shraddha\\\\Desktop\\\\Class\\\\Hotel Booking System\\\\Project Images");
//	@GetMapping("/image/{filename}")
//    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
//        try {
//            Path file = rootLocation.resolve(filename);
//            Resource resource = new  FileSystemResource(file);
//            return ResponseEntity.ok()
//                    .body(resource);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
	
	@GetMapping("/find/{id}")
	public AddHotel findById(@PathVariable int id) {
		AddHotel addHotel=addHotelService.findbyId(id);
		addHotel.setImg1("./../../assets/"+addHotel.getImg1().substring(addHotel.getImg1().lastIndexOf("\\") + 1));
		addHotel.setImg2("./../../assets/"+addHotel.getImg2().substring(addHotel.getImg2().lastIndexOf("\\") + 1));
		addHotel.setImg3("./../../assets/"+addHotel.getImg3().substring(addHotel.getImg3().lastIndexOf("\\") + 1));
        
        return addHotel;
		
	}
	
	

	
	@GetMapping("findAll")
    public List<AddHotel> getAllHotels() {
		
        List<AddHotel> addHotel=addHotelService.findAll();
        for (AddHotel hotel : addHotel) {
            hotel.setImg1("./../../assets/"+hotel.getImg1().substring(hotel.getImg1().lastIndexOf("\\") + 1));
            hotel.setImg2("./../../assets/"+hotel.getImg2().substring(hotel.getImg2().lastIndexOf("\\") + 1));
            hotel.setImg3("./../../assets/"+hotel.getImg3().substring(hotel.getImg3().lastIndexOf("\\") + 1));
        }
        return addHotel;
    }
	
	@GetMapping("findByName/{hotelName}")
	public AddHotel findName(@PathVariable String hotelName) {
		return addHotelService.findByHotelName(hotelName);
	}

	
	}


