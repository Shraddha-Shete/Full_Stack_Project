package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ManagerDto;

import com.example.demo.entity.Manager;
import com.example.demo.loginResponse.LoginMessage;
import com.example.demo.service.ManagerService;

@RestController
@CrossOrigin("*")
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public Manager saveManager(@RequestBody ManagerDto managerDto) {
		return managerService.save(managerDto);
	}
	
	@PostMapping("/loginManager")
	 public ResponseEntity<?> loginResponse(@RequestBody LoginDto loginDto){
		 LoginMessage loginMessage=managerService.loginCustomer(loginDto);
		 return ResponseEntity.ok(loginMessage);
	 }

	@PostMapping("/{managerId}/associateHotel/{hotelId}")
    public ResponseEntity<Manager> associateHotelWithManager(@PathVariable int managerId, @PathVariable int hotelId) {
        Manager manager = managerService.associateHotelWithManager(managerId, hotelId);
        return ResponseEntity.ok(manager);
    }

	@GetMapping("/byAdminName/{adminName}")
	public ResponseEntity<Manager> getManagerByAdminName(@PathVariable String adminName) {
	     Manager manager = managerService.findByAdminName(adminName);
	     if (manager != null) {
	         return ResponseEntity.ok(manager);
	       } else {
	          return ResponseEntity.notFound().build();
	       }
	    }
	
	@GetMapping("/byEmail/{email}")
	public Manager findByEmail(@PathVariable String email ) {
		return managerService.findByEmail(email);
	}
}
