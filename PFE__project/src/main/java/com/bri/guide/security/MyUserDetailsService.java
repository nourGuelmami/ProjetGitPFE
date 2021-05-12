package com.bri.guide.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bri.guide.model.User;
import com.bri.guide.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;


@Service
//la classe MyUserDetailsService implemente l'interface UserDetailsService
public class MyUserDetailsService implements UserDetailsService { //UserDetailsService est utilisée pour récupérer les données liées à l’utilisateur

	//création d'un objet userRepository en appelant les dependances avec l'annotation @Autowired
	@Autowired
	UserRepository userRepository;
	
	//la methode loadUserByUsername permet de trouver un utilisateur donné par son username 
	@Override //l'annotation @Override indique que cest une mehode hérite de la classe/interface mere
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//retourné un objet de type User cherché par son username
		User user= userRepository.findByUsername(username);
		if (user == null) //si l'utilisateur n'existe pas une exception sera lancer
			throw new UsernameNotFoundException("Invalid username or password!!");
		//sinon on retourne l'objet de la classe MyUserDetails
		//on ne peut pas retourner un objet de UserDetails car cest une interface donc on a créer une classe qui implemente 
		//l'interface UserDetails cest la classe MyUserDetails
		return new MyUserDetails(user);
	}

}
