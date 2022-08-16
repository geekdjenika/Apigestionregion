package com.malitourist.Apigestionregion.Services;

import java.util.List;

import com.malitourist.Apigestionregion.Exception.Existedeja;
import com.malitourist.Apigestionregion.Exception.Nonexistant;
import com.malitourist.Apigestionregion.Modele.Pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.malitourist.Apigestionregion.Depot.DepotRegion;
import com.malitourist.Apigestionregion.Modele.Region;

import javax.persistence.EntityManager;

@Service
public class ServiceRegion {
	@Autowired
	public DepotRegion depotregion;
	EntityManager entityManager;

	public Region findByCoderegion(Region region) {
		return depotregion.findByCoderegion(region.getCoderegion());
	}

	//Ajout d'une région à la liste
	public String ajouterRegion(Region region) {
		//return depotregion.save(region);
		Region regionexistant = depotregion.findByCoderegion(region.getCoderegion());
		if(regionexistant==null) {
			/*entityManager.createNamedQuery("INSERT INTO malitourist_region.habitant(nb_habitant) values (\"?\")", ServiceRegion.class)
					.setParameter(1,region.getPays()).executeUpdate();
			entityManager.createNamedQuery("INSERT INTO malitourist_region.pays(nom) values (\"?\")", ServiceRegion.class)
					.setParameter(1,region.getPays()).executeUpdate();
			depotregion.save(region);*/
			depotregion.save(region);
			return "Region ajouté avec succès !";
		}
		else {
			return "Cette région existe déjà !";
			//throw new Existedeja( "Cette région existe déjà !");
		}
	}
	/*public List<Region> ajouterRegion(List<Region> regions) {
		return depotregion.saveAll(regions);
	}*/

	//Affichage de la liste des régions avec pays
	public List<Region> getRegion() {
		return depotregion.findAll();
	}

	//Affichage de la liste des régions sans pays
	public Iterable<Object[]> getRegionsanspays() {
		return depotregion.listeRegionSansPays();
	}

	//Affichage d'une région spécifique en fonction de son id
	public Region getRegionById(long id) {
		return depotregion.findById(id).orElseThrow(
				() -> new Nonexistant(
						"Pas de région à l'id "+id
				)
		);
	}
	
//	public Region getRegionByPays(Pays pays) {
//		return depotregion.findByPays(pays).orElse(null);
//	}


	//Suppression d'une région à travers son id
	public String supprimerRegion(long id) {
		Region regionExistant=depotregion.findById(id).orElse(null);
		if (regionExistant != null) {
			depotregion.deleteById(id);
			return "Region "+id+" supprimé avec succès!";
		} else throw new Nonexistant(
				"La région que vous voulez supprimer n'existe pas !"
		);
		//

	}
	
	public String modifierRegion(Region region) {
		Region regionExistant=depotregion.findById(region.getId()).orElse(null);
		if(regionExistant == null) {
			return "La région que vous voulez modifier n'existe pas !";
		} else {

			regionExistant.setCoderegion(region.getCoderegion());
			regionExistant.setDomaine_activite(region.getDomaine_activite());
			regionExistant.setLangue(region.getLangue());
			regionExistant.setNom(region.getNom());
			regionExistant.setPays(region.getPays());
			regionExistant.setSuperficie(region.getSuperficie());
			return "Région modifié avec succès !";
		}

	}
	
}
