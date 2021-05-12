package com.bri.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bri.guide.model.Genre_user;
import com.bri.guide.repository.Genre_userRepository;

@Service
public class GenreService {
	@Autowired
	Genre_userRepository genderRepository;
	
	public List<Genre_user> getGenders(){
		return genderRepository.findAll();
	}
	

}
