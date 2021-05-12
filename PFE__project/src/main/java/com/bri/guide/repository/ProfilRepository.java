package com.bri.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bri.guide.model.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Integer> {

	@Query("SELECT p FROM Profil p WHERE p.lib_profil=?1")
	public Profil findByLibelle(String libelle);
	
	
}
