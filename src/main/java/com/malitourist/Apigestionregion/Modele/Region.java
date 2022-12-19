package com.malitourist.Apigestionregion.Modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
	public Pays pays;
	@Column
	public String domaine_activite;
	@Column
	public String superficie;
	@Column
	public String langue;

	@OneToMany //LAZY pour que les roles ne soit pas chargés automatiquement lors du chargement de l'utilisateur
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<Commentaire> commentaires = new ArrayList<>();

}
