package com.bri.guide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bri.guide.model.Genre_user;
import com.bri.guide.model.Newsletter;
import com.bri.guide.model.Profil;
import com.bri.guide.model.User;
import com.bri.guide.repository.Genre_userRepository;
import com.bri.guide.repository.NewsletterRepository;
import com.bri.guide.repository.PrivilegeRepository;
import com.bri.guide.repository.ProfilRepository;
import com.bri.guide.repository.UserRepository;

@SpringBootApplication
public class PfeProjectApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Autowired
	ProfilRepository profilRepository;
	
	@Autowired
	Genre_userRepository genreRepository;
	
	@Autowired
	NewsletterRepository newsletterRepo;

	public static void main(String[] args) {
		SpringApplication.run(PfeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Newsletter newsletter1 = new Newsletter(1,"Publications filière viande",
		 * null); Newsletter newsletter2 = new
		 * Newsletter(3,"Publications filière sucre", null);
		 * 
		 * User user= new User();
		 * 
		 * user.setId_user(68); user.setNom_user_ar("sana");
		 * user.setNom_user_en("sana"); user.setNom_user_fr("sana");
		 * user.setPrenom_user_ar("saadi"); user.setPrenom_user_en("saadi");
		 * user.setPrenom_user_fr("saadi"); user.setPwd_user("bonjour123");
		 * user.setUsername("sana"); user.setTel1_user("+216 24100200");
		 * user.setTel2_user("+216 71554460"); user.setEmail1_user("sana@gmail.com");
		 * user.setEmail2_user("sana@gmail.com"); user.setAdr_user("tunis"); //User
		 * user2 = new User("karlie", "karlie", "karlie", "karlie", "karlie", "karlie",
		 * "karlie", "karlie", "karlie", null, "karlie", "karlie", "karlie", "karlie",
		 * null, null, null, null, "karlie");
		 * 
		 * //on ajoute un user a une newsletter newsletter1.getUsers().add(user);
		 * newsletter2.getUsers().add(user); //newsletter1.getUsers().add(user2);
		 * 
		 * //on ajoute une newsletter a un user
		 * 
		 * user.getNewsletters().add(newsletter1);
		 * user.getNewsletters().add(newsletter1);
		 * 
		 * this.newsletterRepo.save(newsletter1); this.newsletterRepo.save(newsletter2);
		 * 
		 */		
				/*
		 * //on va créer un objet de type Newsletter Newsletter newsletter = new
		 * Newsletter();
		 * 
		 * newsletter.setId_newsletter(3);
		 * newsletter.setSujet_newsletter("sujet sur les produits laitiers");
		 * newsletterRepo.save(newsletter);
		 */
		  //on va créer un objet user de type User 
			
			/*
			 * User user= new User();
			 * 
			 * user.setId_user(5); user.setNom_user_ar("nour"); user.setNom_user_en("nour");
			 * user.setNom_user_fr("nour"); user.setPrenom_user_ar("kamoun");
			 * user.setPrenom_user_en("kamoun"); user.setPrenom_user_fr("kamoun");
			 * user.setPwd_user("nouur"); user.setUsername("nour");
			 * user.setTel1_user("+216 58490933"); user.setTel2_user("+216 71554460");
			 * user.setEmail1_user("nourguelmami21@gmail.com");
			 * user.setEmail2_user("nour@gmail.com"); user.setAdr_user("tunis");
			 * 
			 * //on enregistre les informations de l'objet user avec la fonction
			 * save()delinterface userRepository userRepository.save(user);
			 */
			 
		 
		/*
		 * 
		 * 
		 * 
		 * //on va créer un objet privilege de type Privilege Privilege privilege= new
		 * Privilege();
		 * 
		 * privilege.setId_privilege(2); privilege.setLib_privilege("user");
		 * privilege.setDescr_privilege("visualiation et ajout");
		 * privilegeRepository.save(privilege);
		 */
	
		
		
		/*
		 * //on va créer un bjet profil de type Profil Profil profil = new Profil();
		 * profil.setId_profil(1); profil.setLib_profil("user");
		 * profil.setDescr_profil("visualisation");
		 * 
		 * profilRepository.save(profil);
		 */
		
		
		/*
		 * //on va créer un objet genre de type Genre_user Genre_user genre = new
		 * Genre_user(); genre.setId_genre_user(2); genre.setLib_genre_user_ar("ذكر");
		 * genre.setLib_genre_user_en("Homme"); genre.setLib_genre_user_fr("Men");
		 * 
		 * genreRepository.save(genre);
		 */
			}
	
	
	
	

}
