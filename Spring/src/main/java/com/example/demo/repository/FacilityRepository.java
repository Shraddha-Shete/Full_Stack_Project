package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	List<Facility> findByHotelId(int hotelId);
    List<Facility> findByManagerId(Long managerId);
}
