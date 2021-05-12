package com.bri.guide.model;

import java.io.Serializable;

public class CleAction_User implements Serializable {
	//on declare les deux objets user et action comme attributs de cette classe
	//puisque la cle sera composées entre les deux cles des tables user et action
	User user;
	Action action;
	
	
}
