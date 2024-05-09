package com.patient.utility;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpUtil {
	
	  public String generateOTP() {
	        Random random = new Random();
	        int otpNumber = 100000 + random.nextInt(900000);
	        return String.valueOf(otpNumber);
	    }

}
