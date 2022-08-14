package com.malitourist.Apigestionregion.Modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pays {

	@Id
	@Column(name = "nom")
	public String nom;
	
	public Pays() {}
	
	public Pays(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
