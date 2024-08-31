package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Customer;
import com.example.demo.loginResponse.LoginMessage;

public interface CustomerService {
	public Customer saveCustomer(CustomerDto customerDto);
    LoginMessage loginCustomer(LoginDto loginDto);

}
