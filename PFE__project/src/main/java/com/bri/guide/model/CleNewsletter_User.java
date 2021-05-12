package com.bri.guide.model;

import java.io.Serializable;

public class CleNewsletter_User implements Serializable {
	//on declare les deux objets user et newsletter comme attributs de cette classe
	//puisque la cle sera composées entre les deux cles des tables user et newsletter
	Newsletter newsletter;
	User user;

}
