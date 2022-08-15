package com.malitourist.Apigestionregion.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malitourist.Apigestionregion.Depot.DepotHabitant;
import com.malitourist.Apigestionregion.Modele.Habitant;

@Service
public class ServiceHabitant {
	@Autowired
	public DepotHabitant depothabitant;
	
	public Habitant ajouterHabitant(Habitant habitant) {
		return depothabitant.save(habitant);
	}
	
	public List<Habitant> getHabitant() {
		return depothabitant.findAll();
	}
	
	/*public String supprimerHabitant(long id) {
		depothabitant.deleteById(id);
		return "Habitant "+id+" supprimé avec succès!";
	}*/
	
//	public Habitant modifierHabitant(Habitant habitant) {
//		Habitant habitantExistant=depothabitant.findById(habitant.getNb_habitant()).orElse(null);
//		
//		habitantExistant.setNb_habitant(habitant.getNb_habitant());
//		habitantExistant.setAnnee(habitant.getAnnee());
//		return depothabitant.save(habitantExistant);
//	}

}
