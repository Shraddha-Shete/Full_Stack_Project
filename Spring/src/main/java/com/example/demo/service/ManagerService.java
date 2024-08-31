package com.example.demo.service;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Manager;
import com.example.demo.loginResponse.LoginMessage;
import com.example.demo.entity.Customer;

public interface ManagerService {
	public Manager save(ManagerDto managerDto);
	
	LoginMessage loginCustomer(LoginDto loginDto);
	
	Manager associateHotelWithManager(int managerId, int hotelId);
	 public Manager findByAdminName(String adminName);
	 public Manager findByEmail(String email);
}
