package com.bri.guide.service;

import com.bri.guide.dto.UserRegistration;
import com.bri.guide.model.User;

public interface UserServices {
	
	public User save(UserRegistration userRegistration);
 
	//public User saveDeletedUser(UserRegistration user);
}
