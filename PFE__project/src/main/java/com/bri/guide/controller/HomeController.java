package com.bri.guide.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bri.guide.model.Genre_user;
import com.bri.guide.model.Newsletter;
import com.bri.guide.model.Profil;
import com.bri.guide.model.User;
import com.bri.guide.service.GenreService;
import com.bri.guide.service.NewsletterService;
import com.bri.guide.service.ProfilService;
import com.bri.guide.service.UserService;


//@Controller
@RestController
public class HomeController {
	
	//on ajoute l'annotation @Autowired pour instancier un objet de type UserService en appelant les dependances 
	@Autowired
	UserService userService;
	
	@Autowired
	GenreService genderService;
	
	@Autowired
	ProfilService profilService;
	
	@Autowired
	NewsletterService newsletterService;
	
	/*
	 * @RequestMapping("/welcome") public String Accueil() { return "Welcome"; }
	 * 
	 * @RequestMapping("/login") public String login() { return "login"; }
	 * 
	 * @RequestMapping("/admin") public String showAdminPage() { return "adminHome";
	 * }
	 */
	
	//@RequestMapping("/GestionUser")
	//public String home(Model model) {
	//	return listByPage(model, 1);
	//}
	
	
	//pagination methode
	//@GetMapping("/page/{pageNumber}")
	/*
	 * public String listByPage(Model model, @PathVariable("pageNumber") int
	 * currentPage) { //on declare une liste de type User qui permet de retourner la
	 * liste de tous les utilisateurs par la methode getAllUsers //de la classe
	 * userService
	 * 
	 * Page<User> page= userService.getAllUsers(currentPage); long totalItems =
	 * page.getTotalElements(); int totalPages = page.getTotalPages(); List<User>
	 * list = page.getContent();
	 * 
	 * //on injecte la liste retourner dans le modele
	 * model.addAttribute("currentPage", currentPage);
	 * model.addAttribute("totalItems", totalItems);
	 * model.addAttribute("totalPages", totalPages); model.addAttribute("users",
	 * list); return "homePage"; }
	 */

	@GetMapping(value="/listUsers")
	public List<User> findAllUsers(){
		return userService.getAllUsers();
	}
	
	
	
	
	
	
	// Pour la modification:
	//@RequestMapping(path= {"/edit/{id}"}) //on va utiliser @PathVariable qui prend la valeur de l'espace reserve dans l'URI
	//car on ne connait pas la syntaxe de la proprietes id
	/*
	 * public String updateUser(Model model, @PathVariable(name="id")int id) { //on
	 * declare un objet de type User qui recoit le meme id User user=
	 * userService.getUserById(id); //on ajoute les profils
	 * 
	 * List<Profil> profils = profilService.getProfiles();
	 * 
	 * List<Genre_user> genders = genderService.getGenders();
	 * 
	 * List<Newsletter> nwesletter= newsletterService.getNewsletter();
	 * 
	 * //on fait appel a la methode updateUser de la classe UserService
	 * userService.updateUser(user); //on injecte le resultat dans un modele pour
	 * qu'on puisse travailler avec dans la vue updateUser
	 * model.addAttribute("user", user); model.addAttribute("listProfils", profils);
	 * model.addAttribute("listGenders", genders);
	 * model.addAttribute("listNewsletter", nwesletter); return "updateUser"; }
	 */
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public User updateUser(Model model,@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}
	
	
	
	
	//la methode save permet d'enregistrer les informations sur un utilisateur
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		//on fait appelle a la methode saveUser de la classe service
		 userService.saveUser(user);
		return "redirect:/GestionUser"; //redirection a la page home
	}
	

	
	//pour la suppression
	/*
	 * @RequestMapping(path= { "/delete/{id}"}) public String
	 * deleteUser(@PathVariable(name="id")int id ) { User user =
	 * userService.getUserById(id); userService.saveUser(user);
	 * 
	 * 
	 * //on fait appelle a la methode deleteUser de la classe UserService
	 * userService.deleteUser(id);
	 * 
	 * return "redirect:/GestionUser"; }
	 */
	@RequestMapping(value="/delete")
	public String deleteUser(@RequestParam int id) {
		 userService.deleteUser(id);
		 return "User Deleted";
	}
	  
	  @RequestMapping("/deletedUsers")
		public String showDeletedUsersList() {
		
			return "DeletedUser";
		}
	 
	@RequestMapping("/homePage")
	public String logout() {
		return "logout";
	}
	
	
}
