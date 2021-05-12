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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//on ajoute l'annotation @Entity pour appliquer la persistance a la classe User
@Entity
//on ajoute l'annotation @Table pour redefinir le nom de la table 
@Table(name="user_table")
public class User implements Serializable {
	//on declare les attributs de la classe user
	//on ajoute l'annotation @Id juste au dessus de l'attribut id_user pour dire que cet attribut 
	//corresspond a une cle primaie dans la table user_table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_user;
	//on ajoute l'annotation @Column pour specifier la taille du champs,
    //pour empecher cette colonne de porter des valeurs nulles
	@Column(name="nom_user_ar", length=45 ) 
	String nom_user_ar;
	
	@Column(name="nom_user_fr" ,nullable=false, length=45 ) 
	String nom_user_fr;
	
	@Column(name="nom_user_en", length=45 ) 
	String nom_user_en;
	
	@Column(name="prenom_user_ar" , length=45 ) 
	String prenom_user_ar;
	
	@Column(name="prenom_user_fr",nullable=false, length=45 ) 
	String prenom_user_fr;
	
	@Column(name="prenom_user_en", length=45 ) 
	String prenom_user_en;
	
	@Column(name="pwd_user",nullable=false, length=100) 
	String pwd_user;
	
	@Column(name="reset_password", length=100) 
	String resetPassword;
	
	@Column(name="username",nullable=false, length=30 ) 
	String username;
	
	@Column(name="tel1_user" , length=45) 
	String tel1_user;
	
	@Column(name="tel2_user", length=45) 
	String tel2_user;
	
	@Temporal(TemporalType.TIMESTAMP)//on ajoute l'annotation @Temporal pour enregistrer les deux informations heure et date de la journée
	Date date_creat_user = new Date(System.currentTimeMillis());
	
	//@Temporal(TemporalType.DATE) //on ajoute lannotation @Temporal pour enregistrer les dates en tant que jour/mois/année
	String date_naiss_user;
	
	@Column(name="email1_user",nullable=false,length=150) 
	String email1_user;
	
	@Column(name="email2_user", length=150) 
	String email2_user;
	
	String adr_user;
	
	
	
	//on declare les associations:	
	
	// 1. on a une relation 1,1 avec la table Type_User donc on va ajouter l'annotation @OneToOne
	//un utilisateur peut avoir un et un seul type
	@OneToOne
	Type_User typeUser;
	
	// 2.on a une relation 1,1 avec la table Genre_user donc on va ajouter l'annotation @OneToOne
	//un utilisateur peut avoir un et un seul genre soit homme ou femme
	@OneToOne
	public Genre_user gender;
	
	// 3.on a une relation 1,1 avec la table Fonction_user donc on va ajouter l'annotation @OneToOne
    //un utilisateur peut avoir une et une seule fonction
		@OneToOne
		Fonction_user fonctionUser;
	
	
	// 4.on a une relation 1,1 avec la table Profil donc on va ajouter l'annotation @OneToOne
    //un utilisateur peut avoir un et un seul profil
			
		   @OneToOne//on ajoute cascadetype.ALL : si on mis a jour un user ou on le supprime son profil sera mis ajour ou supprimé aussi
			public Profil profil ;
			
			
			/*on a une relation n,n entre la table user et Newsletter
			 * ce qui fait la creation d'une nouvelle classe (table d'effet) newsletter_user
			 * la relation devient @OneToMany coté user et @ManyToOne cote la table d'effet
			 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
			 *l'annotation @ManyToOne pour chaque attributs 
			 *et l'annotation @JoinColumn pour chaqu'un des cles 
			 */
			/*
			 * @OneToMany List<Newsletter_user> list_newsletters;
			 */
			
			
			/*on a une relation n,n entre la table user et Action
			 * ce qui fait la creation d'une nouvelle classe (table d'effet) action_user
			 * la relation devient @OneToMany coté user et @ManyToOne cote la table d'effet
			 *cete table contient comme attributs les deux clés primaires des 2tables avec l'annotation @Id pour chaque attribut
			 *l'annotation @ManyToOne pour chaque attributs 
			 *et l'annotation @JoinColumn pour chaqu'un des cles 
			 */
			@OneToMany
			List<Journalisation> list_actions;
			
			@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
			@JoinTable(name="Newsletter_User",
			joinColumns = { @JoinColumn(name="id_user")},
			inverseJoinColumns = {@JoinColumn(name="id_newsletter")})
			public Set<Newsletter> newsletters=new HashSet<>();
			
			
			
	

	//declaration d'un constructeur parametre
	public User(String nom_user_ar, String nom_user_fr, String nom_user_en, String prenom_user_ar,
			String prenom_user_fr, String prenom_user_en, String pwd_user, String tel1_user, String tel2_user,
			Date date_creat_user, String date_naiss_user, String email1_user, String email2_user, String adr_user,
			Type_User typeUser, Genre_user gender, Fonction_user fonctionUser, Profil profil, String resetPassword) {
		super();
		//id
		this.nom_user_ar = nom_user_ar;
		this.nom_user_fr = nom_user_fr;
		this.nom_user_en = nom_user_en;
		this.prenom_user_ar = prenom_user_ar;
		this.prenom_user_fr = prenom_user_fr;
		this.prenom_user_en = prenom_user_en;
		this.pwd_user = pwd_user;
		this.tel1_user = tel1_user;
		this.tel2_user = tel2_user;
		this.date_creat_user = date_creat_user;
		this.date_naiss_user = date_naiss_user;
		this.email1_user = email1_user;
		this.email2_user = email2_user;
		this.adr_user = adr_user;
		this.resetPassword= resetPassword;
		this.gender=gender;
		

	}


	//constructeur parametre pour l'eregistrement
	  public User(String nom_user_fr, String prenom_user_fr, String email1_user,
	  String username, String pwd_user, String tel1_user, String date_naiss_user,
	  String adr_user, Profil profil, Genre_user gender, Set<Newsletter> newsletters
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
	  this.newsletters= newsletters;
	  }
	 


	public User() {
		super();
	}


	//declaration des geters et setters
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNom_user_ar() {
		return nom_user_ar;
	}

	public void setNom_user_ar(String nom_user_ar) {
		this.nom_user_ar = nom_user_ar;
	}

	public String getNom_user_fr() {
		return nom_user_fr;
	}

	public void setNom_user_fr(String nom_user_fr) {
		this.nom_user_fr = nom_user_fr;
	}

	public String getNom_user_en() {
		return nom_user_en;
	}

	public void setNom_user_en(String nom_user_en) {
		this.nom_user_en = nom_user_en;
	}

	public String getPrenom_user_ar() {
		return prenom_user_ar;
	}

	public void setPrenom_user_ar(String prenom_user_ar) {
		this.prenom_user_ar = prenom_user_ar;
	}

	public String getPrenom_user_fr() {
		return prenom_user_fr;
	}

	public void setPrenom_user_fr(String prenom_user_fr) {
		this.prenom_user_fr = prenom_user_fr;
	}

	public String getPrenom_user_en() {
		return prenom_user_en;
	}

	public void setPrenom_user_en(String prenom_user_en) {
		this.prenom_user_en = prenom_user_en;
	}

	public String getPwd_user() {
		return pwd_user;
	}

	public void setPwd_user(String pwd_user) {
		this.pwd_user = pwd_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTel1_user() {
		return tel1_user;
	}

	public void setTel1_user(String tel1_user) {
		this.tel1_user = tel1_user;
	}

	public String getTel2_user() {
		return tel2_user;
	}

	public void setTel2_user(String tel2_user) {
		this.tel2_user = tel2_user;
	}

	public Date getDate_creat_user() {
		return date_creat_user;
	}

	public void setDate_creat_user(Date date_creat_user) {
		this.date_creat_user = date_creat_user;
	}

	public String getDate_naiss_user() {
		return date_naiss_user;
	}

	public void setDate_naiss_user(String date_naiss_user) {
		this.date_naiss_user = date_naiss_user;
	}

	public String getEmail1_user() {
		return email1_user;
	}

	public void setEmail1_user(String email1_user) {
		this.email1_user = email1_user;
	}

	public String getEmail2_user() {
		return email2_user;
	}

	public void setEmail2_user(String email2_user) {
		this.email2_user = email2_user;
	}

	public String getAdr_user() {
		return adr_user;
	}

	public void setAdr_user(String adr_user) {
		this.adr_user = adr_user;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
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


	public Set<Newsletter> getNewsletters() {
		return newsletters;
	}


	public void setNewsletters(Set<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}


	public void setGender(Genre_user gender) {
		this.gender = gender;
	}


	
	
	
}
