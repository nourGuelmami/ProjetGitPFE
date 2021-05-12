package com.bri.guide.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//on ajoute l'annotation @IdClass pour indiquer que la cle de cette classe est une cle composanee de deux cles primaires des tables action et user
@IdClass(CleAction_User.class)
public class Journalisation implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="id_user")
	User user; //le user est de la classe cleAction_User qui corresspond a un id par l'annotation @Id
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_action")
	Action action;
	
	Date date_journalisation;
	
	
}
