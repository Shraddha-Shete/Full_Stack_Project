package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AddHotel;
import com.example.demo.entity.Facility;
import com.example.demo.entity.Manager;
import com.example.demo.repository.AddHotelRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	AddHotelRepository addHotelRepository;

	@Autowired
	ManagerRepository managerRepository;

	@Override
	public List<Facility> getFacilitiesByHotelId(int hotelId) {
		return facilityRepository.findByHotelId(hotelId);
	}

	@Override
	public List<Facility> getFacilitiesByManagerId(Long managerId) {
		 return facilityRepository.findByManagerId(managerId);
	}

	@Override
	public Facility saveFacility(Facility facility) {
		AddHotel hotel = addHotelRepository.findById(facility.getHotel().getId()).orElse(null);
        Manager manager = managerRepository.findById(facility.getManager().getId()).orElse(null);
        if (hotel == null || manager == null) {
            throw new RuntimeException("Hotel or Manager not found");
        }

        facility.setHotel(hotel);
        facility.setManager(manager);

        return facilityRepository.save(facility);
        
	}
	
	

}
