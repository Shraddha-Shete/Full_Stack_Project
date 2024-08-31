package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @ManyToOne
    private AddHotel hotel;

    @ManyToOne
    private Manager manager;

    public Facility() {
    }

    public Facility(Long id, String name, AddHotel hotel, Manager manager) {
        this.id = id;
        this.name = name;
        this.hotel = hotel;
        this.manager = manager;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddHotel getHotel() {
		return hotel;
	}

	public void setHotel(AddHotel hotel) {
		this.hotel = hotel;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

    
}

