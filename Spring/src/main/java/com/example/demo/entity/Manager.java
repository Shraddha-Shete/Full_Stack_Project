package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Admin_Registration")

public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Admin_id", length = 45)
    private int id;

    @Column(name="First_name", length = 255)
    private String firstName;

    @Column(name="Last_name", length = 255)
    private String lastName;

    @Column(name="Email", length = 255)
    private String email;

    @Column(name="MobNo", length = 255)
    private String mobNo;

    @Column(name="Password", length = 255)
    private String password;

    @Column(name="Role", length = 50)
    private String role;

    @OneToOne
    @JoinColumn(name = "AddHotel_id")
    @JsonManagedReference
    private AddHotel hotel;

	public Manager() {
		
	}

	public Manager(int id, String firstName, String lastName, String email, String mobNo, String password, String role,
			AddHotel hotel) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
		this.role = role;
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AddHotel getHotel() {
		return hotel;
	}

	public void setHotel(AddHotel hotel) {
		this.hotel = hotel;
	}
	
	
	
}

   