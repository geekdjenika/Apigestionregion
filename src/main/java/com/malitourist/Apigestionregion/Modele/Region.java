package com.malitourist.Apigestionregion.Modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor  @NoArgsConstructor
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column(unique = true)
	public String coderegion;
	@Column
	public String nom;
	@ManyToOne
	@JoinColumn(name = "idPays")
	public Pays pays;
	@Column
	public String domaine_activite;
	@Column
	public String superficie;
	@Column
	public String langue;

}
