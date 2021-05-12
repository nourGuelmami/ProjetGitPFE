package com.bri.guide.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//on ajoute l'annotation @Entity pour appliquer la persistance a la classe Newsletter
@Entity
public class Newsletter implements Serializable{
	//on declare les attributs de la classe Newsletter
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_newsletter pour dire que cet attribut 
	//corresspond a une cle primaie dans la table Newsletter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_newsletter;
	
	@Column(name="sujet_newsletter", nullable=false , length=200 ) 
	String sujet_newsletter;
	
	@Temporal(TemporalType.TIMESTAMP)//on ajoute l'annotation @Temporal pour enregistrer les deux informations heure et date de la journée
	//@Column(name="date_newsletter", nullable=false , length=45 ) 
	Date date_newsletter= new Date(System.currentTimeMillis());;
	
	/*on a une relation n,n entre la table user et Newsletter
	 * ce qui fait la creation d'une nouvelle classe (table d'effet) newsletter_user
	 * la relation devient @OneToMany coté Newsletter et @ManyToOne cote la table d'effet
	 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
	 *l'annotation @ManyToOne pour chaque attributs 
	 *et l'annotation @JoinColumn pour chaqu'un des cles 
	 */
	
	/*
	 * @OneToMany List<Newsletter_user> liste_users;
	 */
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy="newsletters")
	public Set<User>users=new HashSet<>();
	
	//on declare un constructeur non parametre
	public Newsletter() {
		super();
		
	}
	
	//on declare un constructeur parametre
	public Newsletter(String sujet_newsletter, Date date_newsletter) {
		super();
		//this.id_newsletter = id_newsletter;
		this.sujet_newsletter = sujet_newsletter;
		this.date_newsletter = date_newsletter;
	}
	
	public Newsletter(int id_newsletter,String sujet_newsletter) {
		super();
		this.id_newsletter = id_newsletter;
		this.sujet_newsletter = sujet_newsletter;
	}
	
	
	//on declare les getters et setters
	public int getId_newsletter() {
		return id_newsletter;
	}
	public void setId_newsletter(int id_newsletter) {
		this.id_newsletter = id_newsletter;
	}
	public String getSujet_newsletter() {
		return sujet_newsletter;
	}
	public void setSujet_newsletter(String sujet_newsletter) {
		this.sujet_newsletter = sujet_newsletter;
	}
	public Date getDate_newsletter() {
		return date_newsletter;
	}
	public void setDate_newsletter(Date date_newsletter) {
		this.date_newsletter = date_newsletter;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	//on ajoute la méthode toString pour convertir l'attribut sujet_newsletter en une chaine de caractere au niveau de la vue
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sujet_newsletter;
	}
	
	
}
