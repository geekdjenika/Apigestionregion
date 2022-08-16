package com.malitourist.Apigestionregion.Modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	public String nb_habitant;
	public int annee;
	@ManyToOne
	@JoinColumn(name = "idRegion")
	public Region region;

}
