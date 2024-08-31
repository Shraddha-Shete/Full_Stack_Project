package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Customer;
import com.example.demo.loginResponse.LoginMessage;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("save")
	 public Customer saveEmployee(@RequestBody CustomerDto customerDto)
	    {
	        return customerService.saveCustomer(customerDto);
	        
	    }
	
	@PostMapping("login")
	 public ResponseEntity<?> loginResponse(@RequestBody LoginDto loginDto){
		 LoginMessage loginMessage=customerService.loginCustomer(loginDto);
		 return ResponseEntity.ok(loginMessage);
	 }

}
