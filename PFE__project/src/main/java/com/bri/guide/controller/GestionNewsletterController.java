package com.bri.guide.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bri.guide.model.Newsletter;
import com.bri.guide.service.NewsletterService;

//on ajoute l'annotation @Controller pour indiquer que cest une classe controleur
@Controller
public class GestionNewsletterController {

	//on ajoute l'annotation @Autowired pour instancier la classe service en appelant ces dependances
	@Autowired
	NewsletterService newsletterService;
	
	
	@GetMapping("/gestionNewsletter")
	public String showNewsletterPage(Model model) {
		List<Newsletter> newsletter = newsletterService.getNewsletter();
		model.addAttribute("newsletter", newsletter);
		return "gestionNewsletter";
	}
	
	@GetMapping("/addNewsletter")
	public String addNewsletter(Model model) {
		
		return "addNewsletter";
	}
	
	/*on utilise l'annotation @ModelAttribute pour lier la valeur de retour de la mrthode userRegistration a un modele nommé user
	 * qu'on va travailler avec au niveau de la vue (page registrationhtml)	 */
	  @ModelAttribute("newsleter") 
	  public Newsletter addNewsletter(){
		  return new Newsletter();
	  }
	 
	
	@PostMapping("/addNewsletter")
     public String registration( @ModelAttribute("newsleter")Newsletter newsletter) {
		
		newsletterService.saveNewsletter(newsletter);
		return"redirect:/gestionNewsletter";
	}
	
	
	
	
	
	
}

