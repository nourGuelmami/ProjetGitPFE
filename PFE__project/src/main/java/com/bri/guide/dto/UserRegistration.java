package com.bri.guide.dto;


import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.bri.guide.model.Genre_user;
import com.bri.guide.model.Newsletter;
import com.bri.guide.model.Profil;


public class UserRegistration {
	//on declare les attributs de la classe UserRegistration
	public String nom_user_fr;
	public String prenom_user_fr;
	public String email1_user;
	public String username;
	@Length(min=6 , max=20)
	public String pwd_user;
	public String tel1_user;
	public String date_naiss_user;
	public String adr_user;
	public Profil profil;
	public Genre_user gender;
	public Set<Newsletter> newsletters;
	
	
	//generation d'un constructeur non parametre
	public UserRegistration() {
		super();
	
	}
	//generation d'un constructeur parametre
	public UserRegistration(String nom_user_fr, String prenom_user_fr, String email1_user, String username,
			String pwd_user, String tel1_user, String date_naiss_user, 
			String adr_user,Profil profil, Genre_user gender , Set<Newsletter> newsletters
			) {
		super();
		this.nom_user_fr = nom_user_fr;
		this.prenom_user_fr = prenom_user_fr;
		this.email1_user = email1_user;
		this.username = username;
		this.pwd_user = pwd_user;
		this.tel1_user = tel1_user;
		this.date_naiss_user = date_naiss_user;
		this.adr_user = adr_user;
		this.profil=profil;
		this.gender=gender;
		this.newsletters=newsletters;
	}
	
	//generation des getters et setters
	public String getNom_user_fr() {
		return nom_user_fr;
	}
	public void setNom_user_fr(String nom_user_fr) {
		this.nom_user_fr = nom_user_fr;
	}
	public String getPrenom_user_fr() {
		return prenom_user_fr;
	}
	public void setPrenom_user_fr(String prenom_user_fr) {
		this.prenom_user_fr = prenom_user_fr;
	}
	public String getEmail1_user() {
		return email1_user;
	}
	public void setEmail1_user(String email1_user) {
		this.email1_user = email1_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd_user() {
		return pwd_user;
	}
	public void setPwd_user(String pwd_user) {
		this.pwd_user = pwd_user;
	}
	public String getTel1_user() {
		return tel1_user;
	}
	public void setTel1_user(String tel1_user) {
		this.tel1_user = tel1_user;
	}
	public String getDate_naiss_user() {
		return date_naiss_user;
	}
	public void setDate_naiss_user(String date_naiss_user) {
		this.date_naiss_user = date_naiss_user;
	}
	public String getAdr_user() {
		return adr_user;
	}
	public void setAdr_user(String adr_user) {
		this.adr_user = adr_user;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public Genre_user getGender() {
		return gender;
	}
	public void setGender(Genre_user gender) {
		this.gender = gender;
	}
	public Set<Newsletter> getNewsletters() {
		return newsletters;
	}
	public void setNewsletters(Set<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}
	
	
	

}
