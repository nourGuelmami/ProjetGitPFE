package com.bri.guide.model;

import java.io.Serializable;

public class CleProfil_Privilege implements Serializable{
	//on declare les deux objets profil et privilege comme attributs de cette classe
	//puisque la cle sera composées entre les deux cles des tables Profil et Privilege
	Profil profil;
	Privilege privilege;

}
