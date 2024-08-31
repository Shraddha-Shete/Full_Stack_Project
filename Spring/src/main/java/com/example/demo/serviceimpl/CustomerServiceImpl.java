package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Customer;
import com.example.demo.loginResponse.LoginMessage;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer customer=new Customer(
			customerDto.getId(),
			customerDto.getFirstName(),
			customerDto.getLastName(),
			customerDto.getEmail(),
			customerDto.getMobNo(),
			this.passwordEncoder.encode(customerDto.getPassword()),
			"Customer"
				);
		
		return customerRepository.save(customer);
		
	}
	CustomerDto customerDto;
	@Override
	public LoginMessage loginCustomer(LoginDto loginDto) {
		
        Customer employee1 = customerRepository.findByEmail(loginDto.getEmail());
        //System.out.println(employee1.getPassword());
        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Customer> customer = customerRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (customer.isPresent()) {
                    return new LoginMessage("Login Success", true, customer.get().getRole());
                } else {
                    return new LoginMessage("Login Failed", false, "");
                }
            } else {
                return new LoginMessage("password Not Match", false, "");
            }
        }else {
            return new LoginMessage("Email not exits", false, "");
        }
    }
		
	}
	


