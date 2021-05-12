package com.bri.guide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//on ajoute l'annotation @Entity pour appliquer la persistance a la classe Privilege
@Entity
@Table(name="privilege")
public class Privilege implements Serializable{
	//on declare les attributs de la classe Privilege
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_privilege pour dire que cet attribut 
	//corresspond a une cle primaie dans la table Privilege
	@Id
	int id_privilege;
	String lib_privilege;
	String descr_privilege;
	

	
	/*on a une relation n,n entre la table profil et privilege
	 * ce qui fait la creation d'une nouvelle classe (table d'effet) action_user
	 * la relation devient @OneToMany coté privilege et @ManyToOne cote la table d'effet
	 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
	 *l'annotation @ManyToOne pour chaque attributs 
	 *et l'annotation @JoinColumn pour chaqu'un des cles 
	 */
	@OneToMany
	List<Profil_privilege> liste_profils;

	
	
	//on declare un constructeur non parmetre
	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//on declare un constructeur parametre
	public Privilege(int id_privilege, String lib_privilege, String descr_privilege) {
		super();
		this.id_privilege = id_privilege;
		this.lib_privilege = lib_privilege;
		this.descr_privilege = descr_privilege;
	}
	
	
	//on declare les getters et setters
	public int getId_privilege() {
		return id_privilege;
	}
	public void setId_privilege(int id_privilege) {
		this.id_privilege = id_privilege;
	}
	public String getLib_privilege() {
		return lib_privilege;
	}
	public void setLib_privilege(String lib_privilege) {
		this.lib_privilege = lib_privilege;
	}
	public String getDescr_privilege() {
		return descr_privilege;
	}
	public void setDescr_privilege(String descr_privilege) {
		this.descr_privilege = descr_privilege;
	}
	
	
	
	
	
}
