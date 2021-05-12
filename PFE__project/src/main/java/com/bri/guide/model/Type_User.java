package com.bri.guide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//on ajoute l'annotation @Entity pour appliquer la persistance a la classe Type_User
@Entity
@Table(name="Type")
public class Type_User implements Serializable {
	//on declare les attributs de la classe Type_User
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_type_user pour dire que cet attribut 
	//corresspond a une cle primaie dans la table Type_User
	
	@Id
	int id_type_user;
	String lib_type_user_ar;
	String lib_type_user_fr;
	String lib_type_user_en;
	String descr_type_user_ar;
	String descr_type_user_fr;
	String descr_type_user_en;
	
	//on declare les associations:
	
	// 1. on a une relation 1,n avec la table user_table donc on va ajouter l'annotation @OneToMany
	//un type peut etre affecter a plusieurs users
	@OneToMany
	List <User> users; //on declare une liste des utilisateurs
	

	
	
	//declaration d'un constructeur non parametre
	public Type_User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//declaration d'un constructeur parametre
	public Type_User(int id_type_user, String lib_type_user_ar, String lib_type_user_fr, String lib_type_user_en,
			String descr_type_user_ar, String descr_type_user_fr, String descr_type_user_en) {
		super();
		this.id_type_user = id_type_user;
		this.lib_type_user_ar = lib_type_user_ar;
		this.lib_type_user_fr = lib_type_user_fr;
		this.lib_type_user_en = lib_type_user_en;
		this.descr_type_user_ar = descr_type_user_ar;
		this.descr_type_user_fr = descr_type_user_fr;
		this.descr_type_user_en = descr_type_user_en;
	}
	
	
	//on declare les getters and setters 
	public int getId_type_user() {
		return id_type_user;
	}
	public void setId_type_user(int id_type_user) {
		this.id_type_user = id_type_user;
	}
	public String getLib_type_user_ar() {
		return lib_type_user_ar;
	}
	public void setLib_type_user_ar(String lib_type_user_ar) {
		this.lib_type_user_ar = lib_type_user_ar;
	}
	public String getLib_type_user_fr() {
		return lib_type_user_fr;
	}
	public void setLib_type_user_fr(String lib_type_user_fr) {
		this.lib_type_user_fr = lib_type_user_fr;
	}
	public String getLib_type_user_en() {
		return lib_type_user_en;
	}
	public void setLib_type_user_en(String lib_type_user_en) {
		this.lib_type_user_en = lib_type_user_en;
	}
	public String getDescr_type_user_ar() {
		return descr_type_user_ar;
	}
	public void setDescr_type_user_ar(String descr_type_user_ar) {
		this.descr_type_user_ar = descr_type_user_ar;
	}
	public String getDescr_type_user_fr() {
		return descr_type_user_fr;
	}
	public void setDescr_type_user_fr(String descr_type_user_fr) {
		this.descr_type_user_fr = descr_type_user_fr;
	}
	public String getDescr_type_user_en() {
		return descr_type_user_en;
	}
	public void setDescr_type_user_en(String descr_type_user_en) {
		this.descr_type_user_en = descr_type_user_en;
	}
	
	
	
	
	
	
	
	
	
}
