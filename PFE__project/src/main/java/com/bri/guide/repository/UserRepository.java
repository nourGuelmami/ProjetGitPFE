package com.bri.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bri.guide.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

	//la methode findByUsername permet de récupérer un User à partir de son nom d’utilisateu
	User findByUsername(String username);
	
	
	//La méthode findByemail1_user() sera utilisee pour verifier les emails dun utilisateur lorsqu'il commence a utiliser la fonction Forgot Password
	@Query("SELECT c FROM User c WHERE c.email1_user = ?1")
	User findByemail1_user(String email1_user);
	
	//on ajoute la methode findByrestPassword pour valider un utilisateur avec son password
	@Query("SELECT c FROM User c WHERE c.resetPassword = ?1")
	User findByresetPassword(String resetPassword);
	
	
}
