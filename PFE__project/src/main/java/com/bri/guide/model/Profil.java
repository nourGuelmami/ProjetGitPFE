package com.bri.guide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//on ajoute l'annotation @Entity pour appliquer la persistance a la classe Profil
@Entity
@Table(name="Profil")
public class Profil implements Serializable {
	//on declare les attributs de la classe Profil
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_profil pour dire que cet attribut 
	//corresspond a une cle primaie dans la table profil
	@Id
	int id_profil;
	
	@Column(name="lib_profil", nullable=false , length=45 ) 
	String lib_profil;
	
	String descr_profil;
	
	//on declare les associations:
	
			// 1. on a une relation 1,n avec la table user_table donc on va ajouter l'annotation @OneToMany
			//le meme profil peut etre affecter a plusieurs users
			@OneToMany//on ajoute cascadetype.ALL : si on mis a jour un user ou on le supprime son profil sera mis ajour ou supprimé aussi
			List <User> users = new ArrayList<>(); //on declare une liste des utilisateurs
			
			/*on a une relation n,n entre la table profil et privilege
			 * ce qui fait la creation d'une nouvelle classe (table d'effet) profil_privilege
			 * la relation devient @OneToMany coté profil et @ManyToOne cote la table d'effet
			 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
			 *l'annotation @ManyToOne pour chaque attributs 
			 *et l'annotation @JoinColumn pour chaqu'un des cles 
			 */
			@OneToMany
			List<Profil_privilege> liste_privileges;


	
	//on declare un constructeur parametre
	public Profil() {
		super();
	}

   
	//on declare un constructeur parametre
	public Profil(int id_profil, String lib_profil, String descr_profil) {
		super();
		this.id_profil = id_profil;
		this.lib_profil = lib_profil;
		this.descr_profil = descr_profil;
	}
	
	public Profil(String lib_profil) {
		this.lib_profil=lib_profil;
	}


	@Override
	public String toString() {
		return this.lib_profil;
	}
	
	
	//on declare les getters et setters
	public int getId_profil() {
		return id_profil;
	}
	public void setId_profil(int id_profil) {
		this.id_profil = id_profil;
	}
	public String getLib_profil() {
		return lib_profil;
	}
	public void setLib_profil(String lib_profil) {
		this.lib_profil = lib_profil;
	}
	public String getDescr_profil() {
		return descr_profil;
	}
	public void setDescr_profil(String descr_profil) {
		this.descr_profil = descr_profil;
	}


	
	
	
	
	
	
}
