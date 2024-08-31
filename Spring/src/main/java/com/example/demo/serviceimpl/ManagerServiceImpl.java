package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Manager;
import com.example.demo.loginResponse.LoginMessage;
import com.example.demo.entity.AddHotel;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AddHotelRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AddHotelRepository addHotelRepository;
	
	@Override
	public Manager save(ManagerDto managerDto) {
		 Manager manager=new Manager();
		 manager.setId(managerDto.getId());
			manager.setFirstName(managerDto.getFirstName());
	        manager.setLastName(managerDto.getLastName());
	        manager.setEmail(managerDto.getEmail());
	        manager.setMobNo(managerDto.getMobNo());
	        manager.setPassword(this.passwordEncoder.encode(managerDto.getPassword()));
	        manager.setRole("Manager");
//	        AddHotel addHotel=addHotelRepository.findByhotelAdmin(managerDto.getFirstName()+" "+ managerDto.getLastName());
//	        if (addHotel == null) {
//	            throw new RuntimeException("Hotel not found");
//	        }
	        manager.setHotel(null);
			
				 
		 return managerRepository.save(manager);
	}
	ManagerDto managerDto;
	@Override
	public LoginMessage loginCustomer(LoginDto loginDto) {
		
        Manager employee1 = managerRepository.findByEmail(loginDto.getEmail());
        //System.out.println(employee1.getPassword());
        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Manager> manager = managerRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (manager.isPresent()) {
                    return new LoginMessage("Login Success", true, manager.get().getRole());
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
        
        
	@Override
	public Manager associateHotelWithManager(int managerId, int hotelId) {
		 Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager not found"));
	        AddHotel hotel = addHotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));

	        manager.setHotel(hotel);
	        return managerRepository.save(manager);
	}
	
	 @Override
	    public Manager findByAdminName(String adminName) {
	        String[] nameParts = adminName.split(" ");
	        if (nameParts.length < 2) {
	            return null;
	        }
	        String firstName = nameParts[0];
	        String lastName = nameParts[1];
	        return managerRepository.findByFirstNameAndLastName(firstName, lastName);
	    }
	 
	 @Override
	 public Manager findByEmail(String email) {
		 return managerRepository.findByEmail(email);
	 }

}
