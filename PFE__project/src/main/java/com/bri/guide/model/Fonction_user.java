

package com.bri.guide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//on ajoute l'annotation @Entity pour appliquer la persistance a la classe Fonction_user
@Entity
@Table(name="fonction")
public class Fonction_user implements Serializable{

	//on declare les attributs de la classe Fonction_user
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_fonct_user pour dire que cet attribut 
	//corresspond a une cle primaie dans la table Fonction_user
	@Id
     int id_fonct_user;
     String lib_fonct_user_ar;
     String lib_fonct_user_fr;
     String lib_fonct_user_en;
     
     
		// 1. on a une relation 1,n avec la table user_table donc on va ajouter l'annotation @OneToMany
		//une fonction peut etre affecter a plusieurs users
		@OneToMany
		List <User> users; //on declare une liste des utilisateurs
         
     
   
   //declaration d'un constructeur non parametre  
     public Fonction_user() {
		super();
		// TODO Auto-generated constructor stub
	}
     
     //declaration d'un constructeur parametre
	public Fonction_user(int id_fonct_user, String lib_fonct_user_ar, String lib_fonct_user_fr,
			String lib_fonct_user_en) {
		super();
		this.id_fonct_user = id_fonct_user;
		this.lib_fonct_user_ar = lib_fonct_user_ar;
		this.lib_fonct_user_fr = lib_fonct_user_fr;
		this.lib_fonct_user_en = lib_fonct_user_en;
	}
	
	
	//declaration des getters et setters
	public int getId_fonct_user() {
		return id_fonct_user;
	}
	public void setId_fonct_user(int id_fonct_user) {
		this.id_fonct_user = id_fonct_user;
	}
	public String getLib_fonct_user_ar() {
		return lib_fonct_user_ar;
	}
	public void setLib_fonct_user_ar(String lib_fonct_user_ar) {
		this.lib_fonct_user_ar = lib_fonct_user_ar;
	}
	public String getLib_fonct_user_fr() {
		return lib_fonct_user_fr;
	}
	public void setLib_fonct_user_fr(String lib_fonct_user_fr) {
		this.lib_fonct_user_fr = lib_fonct_user_fr;
	}
	public String getLib_fonct_user_en() {
		return lib_fonct_user_en;
	}
	public void setLib_fonct_user_en(String lib_fonct_user_en) {
		this.lib_fonct_user_en = lib_fonct_user_en;
	}
	
     
     
	
	
	
}
