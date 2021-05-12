package com.bri.guide.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bri.guide.model.Profil;
import com.bri.guide.model.User;


public class MyUserDetails implements UserDetails {
	
//on va créer un objet de type User qu'on va travailler avec
	private User user;
	
//le constructeur de la classe accepte un user qui est passé de la classe UserDetailsService
	public MyUserDetails(User user) {
		super();
		this.user = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Profil profil = user.getProfil();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
			   authorities.add(new SimpleGrantedAuthority(profil.getLib_profil()) );
		   
		
		
		return authorities;
				//Collections.singleton(new SimpleGrantedAuthority("USER")); //on retourne tous les utilisateurs
	}
	@Override
	public String getPassword() {
		
		return user.getPwd_user();
	}
	@Override
	public String getUsername() {
		
		return user.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	 //la methode FullName permet de retourner le nom et le prenom d'utilisateur 
	//on va utiliser cette methode au niveau de la vue adminHome pour afficher le fullName de l'utilisateur qui a l'acces
	public String getFullName() {
		return user.getNom_user_fr() +" " + user.getPrenom_user_fr();
	}

}
