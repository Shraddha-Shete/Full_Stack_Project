package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Facility;

public interface FacilityService {
	public Facility saveFacility(Facility facility);
	public List<Facility> getFacilitiesByHotelId(int hotelId);
	public List<Facility> getFacilitiesByManagerId(Long managerId);

}
