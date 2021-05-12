package com.bri.guide.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//on ajoute l'annotation @Entity pour appliquer la persistance a cette classe
@Entity
//on ajoute l'annotation @IdClass pour indiquer que la cle de cette classe est une cle composante de deux cles primaires des tables profil et privilege
@IdClass(CleProfil_Privilege.class)
public class Profil_privilege implements Serializable {

	//on ajoute les deux attributs de type Profil et Privilege avec les annotations @Id @ManyToOne et @JpoinColumn
	@Id
	@ManyToOne
	@JoinColumn(name="id_privilege")
	Privilege privilege;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_profil")
	Profil profil;
	
	String descr_profil_priv;
	
	@Temporal(TemporalType.TIMESTAMP)//on ajoute l'annotation @Temporal pour enregistrer les deux informations date et heure de la journée
	Date date_affect_profil_priv = new Date(System.currentTimeMillis());

	
	
	
	
}
