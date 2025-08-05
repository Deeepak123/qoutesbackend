package com.backend.proservice.qoutes.util;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class SecurityAPIs {

	private static final List<String> ALLOWED_DOMAINS = List.of(
	        "https://qoutes.com",
	        "http://localhost:4200"
	    );
	
	public boolean verifyToken(HttpServletRequest request) {
    	String clientDomain = request.getHeader("Origin");
  
    	try {
    		return true;
    		
//	    	if(!ALLOWED_DOMAINS.contains(clientDomain)) {
//					return false;
//			}
    	}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
