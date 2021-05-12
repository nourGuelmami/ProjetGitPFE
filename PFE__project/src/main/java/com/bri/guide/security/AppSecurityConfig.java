package com.bri.guide.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//On ajoute l'annotation @Configuration pour que la classe va se scanner et interpréter au démarrage 
@Configuration

//pour qu'on puisse configurer et notre configuration fonctionne on ajoute l'annotation @EnableWebSecurity
@EnableWebSecurity //on desactive les parametres de securité par defaut 
public class AppSecurityConfig extends WebSecurityConfigurerAdapter { //Pour personnaliser la configuration on va créer une classe qui hérite de WebSecurityConfigurerAdaptater
	
	//on va injecter un objet de type UserDetailsService en appelant ces dependances
	//UserDetailsService c'est une interface offerte par Spring Security qui nous permet de récupérer les données liées à l’utilisateur 
	//et faire l'authentification automatiquement
	@Autowired
	private UserDetailsService userDetailsService;

	
	//creation de la methode authProvider pour triter la demande d'authentification et renvoyer un objet entierement authentifie
	//le bean appele est AuthenticationProvider permet de preciser le type d’utilisateur (c.a.d l'objet renvoyer est entierement authentifie)
	@Bean
	public AuthenticationProvider authProvider() {
		//on va créer un objet de type DaoAuthenticationProvider pour charger des détails 
		//sur l’utilisateur de la base de donnees lors de l’authentification
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		//on va specifier le username 
		provider.setUserDetailsService(userDetailsService); //on aura besoin de l'objet userDetailsService pour le usename
		//on specifie le password 
		provider.setPasswordEncoder(new BCryptPasswordEncoder()); //pour lire les mots de passe chiffré
		return provider;	
		
	}

	//Dans la methode configure on definit l'accees a notre application
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable() //on va désactiver la faille de securité 
		     .authorizeRequests()
		     .antMatchers("/welcome")
		     .permitAll() // a ce niveau on autorise l’accees a la route /login
		     .and()
		     .authorizeRequests()
		     .antMatchers("/updateUser")
		     .permitAll()
		     .and()
		     .authorizeRequests()
		     .antMatchers("/login")
		     .permitAll() // a ce niveau on autorise l’accees a la route /login
		     .and() 
		     .authorizeRequests() 
		     .antMatchers("/pwd_forgot") 
		     .permitAll() //on autorise l'acces a la ressource forgot password
		     .and() 
		     .authorizeRequests() 
		     .antMatchers("/registration") 
		     .permitAll()  //on autorise l'acces a la ressource registration
		     .and() 
		     .authorizeRequests() 
		     .antMatchers("/reset_password") 
		     .permitAll() 
		     .and() 
		     .authorizeRequests() 
		     .antMatchers("/reset__password") 
		     .permitAll()
		     .anyRequest().authenticated() //ca veut dire que toutes les ressources doivent etre authentifie
		     .and() //pour ajouter d'autres proprietes
		     .formLogin()
		     .loginPage("/login")
		     .permitAll() //on a ajouter notre page login et autorise l'acces a cette ressource
		     .and()
		     .logout()
		    .logoutSuccessUrl("/homePage?logout")
		    .permitAll()
		    .and()
		    .rememberMe().key("keygtg2565sfvsfdvg") //on ajoute remember me 
		    .userDetailsService(userDetailsService)
		   .tokenValiditySeconds(1*24*60*60); //on ajoute token pour indiquer le temps d'expiration 
		     
	}
	
	/*
	 * .invalidateHttpSession(true) //permet à la session d'être configurée afin
	 * qu'elle ne soit pas invalidée lors de la déconnexion
	 * .clearAuthentication(true) .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout"))
	 */

	/*
	 * @Bean
	 * 
	 * @Override 
	 * protected UserDetailsService userDetailsService() {
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("david").password("123")
	 * .roles("USER").build());
	 * return new InMemoryUserDetailsManager(users);
	 * 
	 * }
	 */

	
	
	
}
