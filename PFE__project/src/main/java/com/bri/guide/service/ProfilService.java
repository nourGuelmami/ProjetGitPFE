package com.bri.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bri.guide.model.Profil;
import com.bri.guide.repository.ProfilRepository;

@Service
public class ProfilService {

	@Autowired
	ProfilRepository profilRepository;
	
	public List<Profil> getProfiles(){
		return profilRepository.findAll();
	}
}
