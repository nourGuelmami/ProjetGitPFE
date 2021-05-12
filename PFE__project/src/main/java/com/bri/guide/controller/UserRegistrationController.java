package com.bri.guide.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bri.guide.dto.UserRegistration;
import com.bri.guide.model.Genre_user;
import com.bri.guide.model.Newsletter;
import com.bri.guide.model.Profil;
import com.bri.guide.service.GenreService;
import com.bri.guide.service.NewsletterService;
import com.bri.guide.service.UserService;

//@Controller
@RestController
public class UserRegistrationController {

	@Autowired
	UserService userService;
	
	@Autowired
	GenreService genderService;
	
	@Autowired
	NewsletterService newsletterService;
	
	//on retourne le formulaire d'inscription
	/*
	 * @GetMapping("/registration") public String showRegistrationForm(Model model)
	 * { List<Genre_user> gender = genderService.getGenders();
	 * model.addAttribute("listGenders", gender);
	 * 
	 * List<Newsletter> nwesletter= newsletterService.getNewsletter();
	 * model.addAttribute("listNewsletter", nwesletter); return"registration"; }
	 */
	
	/*on utilise l'annotation @ModelAttribute pour lier la valeur de retour de la mrthode userRegistration a un modele nommé user
	 * qu'on va travailler avec au niveau de la vue (page registrationhtml)	 */
	  @ModelAttribute("user") 
	  public UserRegistration userRegistration(){
		  return new UserRegistration();
	  }
	 
	
		/*
		 * @PostMapping("/registration") public String
		 * registration(@Valid @ModelAttribute("user")UserRegistration userRegistration,
		 * BindingResult bindingResult) { if(bindingResult.hasFieldErrors()) {
		 * System.out.println("result: "+bindingResult); return "registration"; }
		 * 
		 * userService.save(userRegistration);
		 * System.out.println("///////////////userRegistration: " +userRegistration);
		 * return"redirect:/registration?success"; }
		 */
	
	@PostMapping("/registration")
    public UserRegistration registration(@RequestBody UserRegistration userRegistration) {
      
		
		userService.save(userRegistration);
      System.out.println("///////////////userRegistration: " +userRegistration); 
		return userRegistration;
	}
	
	
	
}
