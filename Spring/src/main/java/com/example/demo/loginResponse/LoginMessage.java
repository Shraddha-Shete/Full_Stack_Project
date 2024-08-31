package com.example.demo.loginResponse;

public class LoginMessage {
	String message;
	Boolean status;
	String role;
	
	public LoginMessage() {
		
	}

	public LoginMessage(String message, Boolean status, String role) {
		
		this.message = message;
		this.status = status;
		this.role=role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginMessage [message=" + message + ", status=" + status + ", role=" + role + "]";
	}

	
	
	
}
