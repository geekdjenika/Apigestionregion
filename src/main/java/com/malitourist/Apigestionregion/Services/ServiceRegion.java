package com.malitourist.Apigestionregion.Services;

import java.util.List;


import com.malitourist.Apigestionregion.Exception.Message;
import com.malitourist.Apigestionregion.Exception.Nonexistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.malitourist.Apigestionregion.Depot.DepotRegion;
import com.malitourist.Apigestionregion.Modele.Region;

@Service
public class ServiceRegion {
	@Autowired
	public DepotRegion depotregion;

	public Region findByName(Region region) {
		return depotregion.findByCoderegion(region.getNom());
	}


	//Ajout d'une région à la liste
	public Object ajouterRegion(Region region) {
		try {
			return depotregion.save(region);
		}catch (Exception e){
			return Message.ErreurReponse("La region "+region.getCoderegion()+ " existe déjà", HttpStatus.OK);
		}
	}

	//Affichage de la liste des régions avec pays
	public List<Region> getRegion() {
		return depotregion.findAll();
	}

	//Affichage de la liste des régions sans pays
	public Iterable<Object[]> getRegionsanspays() {
		return depotregion.listeRegionSansPays();
	}

	//Affichage d'une région spécifique en fonction de son id
	public Object getRegionById(long id) {
		try {
			return depotregion.findById(id);
		} catch (Exception e) {
			return Message.ErreurReponse("Il n'y a pas de région à l'ID "+id,HttpStatus.OK);
		}

	}

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
