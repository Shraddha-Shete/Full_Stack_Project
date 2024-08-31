package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;

@RestController
@CrossOrigin("*")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@PostMapping("addLoc")
	public Location addLoaction(@RequestBody Location location) {
		return locationService.add(location);
	}

}
