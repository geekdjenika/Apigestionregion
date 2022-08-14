package com.malitourist.Apigestionregion.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column
	public String coderegion;
	@Column
	public String nom;
	@ManyToOne
	@JoinColumn(name = "nom_pays")
	public Pays pays;
	@ManyToOne
	@JoinColumn(name = "nb_habitant")
	public Habitant nb_habitant;
	@Column
	public String domaine_activite;
	@Column
	public String superficie;
	@Column
	public String langue;
	
	public Region() {}

	public Region(long id, String coderegion, String nom, Pays pays, Habitant nb_habitant, String domaine_activite,
			String superficie, String langue) {
		this.id = id;
		this.coderegion = coderegion;
		this.nom = nom;
		this.pays = pays;
		this.nb_habitant = nb_habitant;
		this.domaine_activite = domaine_activite;
		this.superficie = superficie;
		this.langue = langue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoderegion() {
		return coderegion;
	}

	public void setCoderegion(String coderegion) {
		this.coderegion = coderegion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Habitant getNb_habitant() {
		return nb_habitant;
	}

	public void setNb_habitant(Habitant nb_habitant) {
		this.nb_habitant = nb_habitant;
	}

	public String getDomaine_activite() {
		return domaine_activite;
	}

	public void setDomaine_activite(String domaine_activite) {
		this.domaine_activite = domaine_activite;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}
}
