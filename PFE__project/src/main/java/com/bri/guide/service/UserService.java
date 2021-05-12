package com.bri.guide.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bri.guide.dto.UserRegistration;
import com.bri.guide.exception.UserNotFoundException;
import com.bri.guide.model.Genre_user;
import com.bri.guide.model.Profil;
import com.bri.guide.model.User;
import com.bri.guide.repository.Genre_userRepository;
import com.bri.guide.repository.ProfilRepository;
import com.bri.guide.repository.UserRepository;

//on ajoute l'annotation @Service pour dire qu'il s'agit d'une classe Service
@Service
public class UserService implements UserServices {
	// instacier un objet de type UserRepository en appelant les dependances
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProfilRepository profileRepo;
	
	@Autowired
	 Genre_userRepository genderRepo;
	
	
		/*
		 * //la methode getAllUsers permet de retourner la liste de tous les
		 * utilisateiurs public Page<User> getAllUsers(int pageNumber){ //on va créer un
		 * objet peagable puisqu'on va travailler avec la notion de pagination Pageable
		 * page =PageRequest.of(pageNumber -1 , 4); //return userRepository.findAll();
		 * et List comme type de retour de la methode getAllUsers return
		 * userRepository.findAll(page); }
		 */
	
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	//la methode getUserById nous permet de retouner un utilisateur par son id
	public User getUserById(int id) {
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			 System.out.println("user :"  +user);
			return user.get();
			
		}else return null;

	}
	
	//la methode deleteUser permet de supprimer un utilisateur  
	public void deleteUser(int id) {
		//on test si l'utilisateur existe par son id par la methode finsById de l'interface UserRepository
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {			 
		
			userRepository.deleteById(id); //si l'utilisateur existe en appelle la fonction deleteById
		}else {
			 System.out.println("user not found"); //exception
		}
	}
	
	//la methode updateUser permet de modifier les informations sur un utilisateur
	public User updateUser(User user) {
		
		//on declare un attribut de type User qu'on va travailler avec 
		//user1 est l'attribut qui va garder les nouvelles informations 
		 Optional<User> user1 = userRepository.findById(user.getId_user()); 
		 if (user1.isPresent()) {

			 System.out.println("user1 :"  +user1);
		 User newUser = user1.get();
		 newUser.setNom_user_fr(user.getNom_user_fr());
		 newUser.setPrenom_user_fr(user.getPrenom_user_fr());
		 newUser.setEmail1_user(user.getEmail1_user());
		 newUser.setTel1_user(user.getTel1_user());
		 newUser.setDate_naiss_user(user.getDate_naiss_user());
		 newUser.setAdr_user(user.getAdr_user());
		 newUser = userRepository.save(newUser);
		
		 return newUser; //si l'utilisateur existe on retourne l'entité newUseer
		 } else {
			 user = userRepository.save(user); //sinon on retourne le meme user
			 return user;
		 }
	}
	
	
	
	public void updateResetPassword(String password , String email) throws UserNotFoundException {
		//on va chercher un utilisayteur par son email grace a la methode findByEmail de l'interface UserRepository
		User user = userRepository.findByemail1_user(email);
		System.out.println("+++++Email: " +email); 
		if(user!=null) {
			//si l'utilisateur est trouvé alors on réinitialise le password (on injecte la valeur de password dans la colonne resetpassword)
			user.setResetPassword(password);
			System.out.println("resetPassword: " +password); 
			//on update les informations de l'utilisateur
			userRepository.save(user);	
			
		}else {
			throw new UserNotFoundException("Could not found any user with email: " +email);
		}
	}
	
	//la methode getResetPassword permet de nous renvoyer un utilisateur cherché par le mot de passe de reinitialisation donne
	public User getResetPassword(String resetPassword) {
		
		return userRepository.findByresetPassword(resetPassword);
		
		
	}
	
	//pour réinitialiser le mot de passe
	public void updatePassword(User user, String newPassword) {
		//on declare une variable de type BCryptPasswordEncoder 
		BCryptPasswordEncoder pwdEncoder= new BCryptPasswordEncoder();
		//on declare une variable de type String pour stocker la nouvelle mot de passe d'une facon crypté
		//on utilise la methode encode() de la classe BCryptPasswordEncoder qui nous permet de chiffré la nouvelle mot de passe 
		String encodedPassword = pwdEncoder.encode(newPassword);
		//on réinitialise la valeur de la colonne Pwd_user et on marque la valeur de resetPassword par null
		user.setPwd_user(encodedPassword);
		user.setResetPassword(null);  
		userRepository.save(user);

	}

	
	
	@Override
	public User save(UserRegistration userRegistration) {
		//on declare un objet de type User 
		User user= new User(userRegistration.getNom_user_fr(),userRegistration.getPrenom_user_fr(),
				userRegistration.getEmail1_user(),userRegistration.getUsername(),
				userRegistration.getPwd_user(),userRegistration.getTel1_user(),
			    userRegistration.getDate_naiss_user(),userRegistration.getAdr_user(),userRegistration.getProfil(),
			    userRegistration.getGender(), userRegistration.getNewsletters());
		//pour crypter le mot de passe on recupere le mot de passe de l'utilisateur 
		String Password=userRegistration.getPwd_user();
		//on a creer un objet de type BCryptPasswordEncoder afain de nous permettre d'utiliser la methode encode() 
		BCryptPasswordEncoder pwdEncoder= new BCryptPasswordEncoder();
		//on declare une variable de type String pour stocker la nouvelle mot de passe d'une facon crypté
		//on utilise la methode encode() de la classe BCryptPasswordEncoder qui nous permet de chiffré la nouvelle mot de passe 
		String encodedPassword = pwdEncoder.encode(Password);
		//on réinitialise la valeur de la colonne Pwd_user et on marque la valeur de resetPassword par null
		user.setPwd_user(encodedPassword);
		Profil profil=profileRepo.findByLibelle("user");
	    user.setProfil(profil);
		return userRepository.save(user);
	}

	/*
	 * @Override public User saveDeletedUser(UserRegistration user) { User
	 * Deleteduser= new User(user.getNom_user_fr(),user.getPrenom_user_fr(),
	 * user.getEmail1_user(),user.getUsername(),
	 * user.getPwd_user(),user.getTel1_user(),
	 * user.getDate_naiss_user(),user.getAdr_user(),user.getProfil(),
	 * user.getGender()); //pour crypter le mot de passe on recupere le mot de passe
	 * de l'utilisateur //String Password=user.getPwd_user(); //on a creer un objet
	 * de type BCryptPasswordEncoder afain de nous permettre d'utiliser la methode
	 * encode() //BCryptPasswordEncoder pwdEncoder= new BCryptPasswordEncoder();
	 * //on declare une variable de type String pour stocker la nouvelle mot de
	 * passe d'une facon crypté //on utilise la methode encode() de la classe
	 * BCryptPasswordEncoder qui nous permet de chiffré la nouvelle mot de passe
	 * //String encodedPassword = pwdEncoder.encode(Password); //on réinitialise la
	 * valeur de la colonne Pwd_user et on marque la valeur de resetPassword par
	 * null //user.setPwd_user(encodedPassword); return
	 * userRepository.save(Deleteduser); }
	 */

	
	
	
}
