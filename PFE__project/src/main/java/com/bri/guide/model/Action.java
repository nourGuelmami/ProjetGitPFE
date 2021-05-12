package com.bri.guide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Action implements Serializable{

	//on declare les attributs de la classe Action
	@Id
	int id_action;
	
	@Column(name="lib_action", nullable=false , length=45) 
	String lib_action;
	
	@Column(name="descr_action", nullable=false , length=45) 
	String descr_action;
	
	

	/*on a une relation n,n entre la table user et Action
	 * ce qui fait la creation d'une nouvelle classe (table d'effet) action_user
	 * la relation devient @OneToMany coté action et @ManyToOne cote la table d'effet
	 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
	 *l'annotation @ManyToOne pour chaque attributs 
	 *et l'annotation @JoinColumn pour chaqu'un des cles 
	 */
	@OneToMany
	List<Journalisation> list_users;
	
	
	
	
	
	//generation d'un constructeur non parametre
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	//generation d'un constructeur parametre
	public Action(int id_action, String lib_action, String descr_action) {
		super();
		this.id_action = id_action;
		this.lib_action = lib_action;
		this.descr_action = descr_action;
	}

	//generation des getters et setters
	public int getId_action() {
		return id_action;
	}

	public void setId_action(int id_action) {
		this.id_action = id_action;
	}

	public String getLib_action() {
		return lib_action;
	}

	public void setLib_action(String lib_action) {
		this.lib_action = lib_action;
	}

	public String getDescr_action() {
		return descr_action;
	}

	public void setDescr_action(String descr_action) {
		this.descr_action = descr_action;
	}
}
