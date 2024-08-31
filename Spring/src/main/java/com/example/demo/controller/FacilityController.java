package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Facility;
import com.example.demo.entity.Manager;
import com.example.demo.service.FacilityService;

@RestController
@CrossOrigin("*")
public class FacilityController {

	@Autowired
	FacilityService facilityService;
	
	@PostMapping("/api/facilities")
    	public Facility createFacility(@RequestBody Facility facility) {
		 	return facilityService.saveFacility(facility);
	}
	
	 @GetMapping("/hotel/{hotelId}")
	    public List<Facility> getFacilitiesByHotelId(@PathVariable int hotelId) {
	        return facilityService.getFacilitiesByHotelId(hotelId);
	    }

	    @GetMapping("/manager/{managerId}")
	    public List<Facility> getFacilitiesByManagerId(@PathVariable Long managerId) {
	        return facilityService.getFacilitiesByManagerId(managerId);
	    }
	    
	    

	    

}
