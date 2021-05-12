package com.bri.guide.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bri.guide.exception.UserNotFoundException;
import com.bri.guide.model.User;
import com.bri.guide.model.Utility;
import com.bri.guide.service.UserService;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	//on ajoute l'annotation @Autowired pour instancier un objet de type UserService en appelant les dependances 
		@Autowired
		UserService userService;
		
		@Autowired //on va instancier un objet de type JavaMailSender avec l'annotation @Autowired pour appeler les dependances
		JavaMailSender mailSender; //javaMailSender est une interface de Spring qui fournit des fonctions pour envoyer un courrier simple 
		
		
		//si utilisateur clique sur le lien Forgot Password la page forgotPassword sera afficher 
		//elle oblige l'utilisateur à entrer un email afin de recevoir le lien de reinitialisation du mot de passe
		@GetMapping("/pwd_forgot")
		public String forgotPasswordPage() {
			return "forgotPassword";
		}
		
		//recuperaion de l'email entré par lutilisateur et création du nouveau mot de passe
	    @PostMapping("/pwd_forgot")
	    public String processForgotPwd(HttpServletRequest request, Model model) {
	    	String email=request.getParameter("email");
	    	//on declare une variable de type String qui prend une chaine aleatoire de longueur >=100 grace a la classe RandomString et la methode make() 
	    	String token= RandomString.make(100);
	    	
	    	//on fait appelle a la methode updateResetPasswordde la classe service pour enregister le nouveau mot de passe généré dans notre base de donnees
	    	try {
				userService.updateResetPassword(token, email);
				String restPasswordLink = Utility.getSiteUrl(request) + "/reset_password?token=" + token;	
				sendEmail(email,restPasswordLink);			
				model.addAttribute("message", "We have sent a reset password link to your email. Please check");
			
	    	} catch (UserNotFoundException ex) {
				model.addAttribute("error", ex.getMessage());
			} catch (UnsupportedEncodingException | MessagingException e) {
				model.addAttribute("error", "error while sending email");
			} 

	    	return"forgotPassword";
	    }

		private void sendEmail(String email, String restPasswordLink) throws UnsupportedEncodingException, MessagingException {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom("contact@guide.com" , "guide support");
			helper.setTo(email);
			String subject = "Here the link to reset password";
			String content = "<p>Hello</p>"
					+"<p>You have requested to reset your password.</p>"
					+"<p>Click the link below to change your password.</p>"
					+"<p><b><a href=\"" + restPasswordLink + "\">Change Password</a><b></p>";
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(message);
		}
		 //retourner le formulaire reset_password pour changer le mot de passe 
			  @GetMapping("/reset_password")
			   public String showResetPassword(@Param(value="token") String token, Model model) {
					
					  User user =userService.getResetPassword(token);
					  System.out.println("user: " +user);
					  
					  if (user != null) { 
						  model.addAttribute("token", token);
					  System.out.println("///////token: " +token); }
					  				 
			  return"reset_Password"; 
			  }
			 

		
		//fonction changePassword
		@PostMapping("/reset__password")
		public String changePassword(HttpServletRequest request, Model model) {
			String token = request.getParameter("token");
			String password = request.getParameter("password");
			String Confirmpassword = request.getParameter("Confirmpassword");
			
			if(Confirmpassword.equals(password)== false) {
				 System.out.println("password: " +password);
				 System.out.println("Confirmpassword: " +Confirmpassword);
				model.addAttribute("error", "Password not match");
				
			}else {
				User user =userService.getResetPassword(token);
				System.out.println("/////////user: " +user); 
				userService.updatePassword(user, password);	
				model.addAttribute("success", "You have successfully changed your password");
			}
			
			return "reset_Password";
		}
}
