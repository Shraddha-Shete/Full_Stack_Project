package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	 public boolean processPayment(String cardNumber, String cardExpiry, String cardCVV, String cardName) {
	        // Dummy payment processing logic
	        return true; // Assume payment is always successful
	    }
}
