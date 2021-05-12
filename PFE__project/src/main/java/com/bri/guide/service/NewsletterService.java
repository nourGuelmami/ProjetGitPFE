package com.bri.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bri.guide.model.Newsletter;
import com.bri.guide.repository.NewsletterRepository;

//on ajoute l'annotation @Service pour indiquer que c'est une classe Service
@Service
public class NewsletterService {

	//on ajoute l'annotation @Autowired pour instancier un objet on appelant les dépendances
	@Autowired
	NewsletterRepository newsletterRepository;
	
	//la methode getNewsletter permet de retourner la liste de tous les newsletter 
	public List<Newsletter> getNewsletter(){
		return newsletterRepository.findAll();
	}
	
	//la methode saveNewsletter permet d'enregistrer les newsletter
	public void saveNewsletter(Newsletter newsletter) {
       //new Newsletter(newsletter.getId_newsletter(),newsletter.getSujet_newsletter());
       
		newsletterRepository.save(newsletter);
	}
}
