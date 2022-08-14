package com.malitourist.Apigestionregion.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malitourist.Apigestionregion.Depot.DepotPays;
import com.malitourist.Apigestionregion.Modele.Pays;

@Service
public class ServicePays {
	@Autowired
	public DepotPays depotpays;
	
	public Pays ajouterPays(Pays pays) {
		return depotpays.save(pays);
	}
	
	public List<Pays> getPays() {
		return depotpays.findAll();
	}
	
	public String supprimerPays(long id) {
		depotpays.deleteById(id);
		return "Pays "+id+" supprimé avec succès!";
	}
	
//	public Pays modifierPays(Pays pays) {
//		Pays paysExistant=depotpays.findById(pays.getIdPays()).orElse(null);
//		
//		paysExistant.setNom(pays.getNom());
//		return depotpays.save(paysExistant);
//	}
	

}
