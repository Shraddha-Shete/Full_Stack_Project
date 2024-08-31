package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	Optional<Manager> findOneByEmailAndPassword(String email, String password);
    Manager findByEmail(String email);
	Manager findByFirstName(String hotelAdmin);
	Manager findByFirstNameAndLastName(String firstName, String lastName);
		
		
}
