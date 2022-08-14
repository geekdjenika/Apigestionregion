package com.malitourist.Apigestionregion.Modele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Habitant {
	@Id
	@Column(name = "nb_habitant")
	public String nb_habitant;
	@Column
	public int annee;
	
	public Habitant() {}

	public Habitant(String nb_habitant, int annee) {
		this.nb_habitant = nb_habitant;
		this.annee = annee;
	}

	public String getNb_habitant() {
		return nb_habitant;
	}

	public void setNb_habitant(String nb_habitant) {
		this.nb_habitant = nb_habitant;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	

	

}
