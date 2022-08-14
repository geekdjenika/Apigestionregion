package com.malitourist.Apigestionregion.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malitourist.Apigestionregion.Depot.DepotRegion;
import com.malitourist.Apigestionregion.Modele.Region;
@Service
public class ServiceRegion {
	@Autowired
	public DepotRegion depotregion;
	
	public Region ajouterRegion(Region region) {
		return depotregion.save(region);
	}
	public List<Region> ajouterRegion(List<Region> regions) {
		return depotregion.saveAll(regions);
	}
	
	public List<Region> getRegion() {
		return depotregion.findAll();
	}
	
	public Iterable<Object[]> getRegionsanspays() {
		return depotregion.listeRegionSansPays();
	}
	
	public Region getRegionById(long id) {
		return depotregion.findById(id).orElse(null);
	}
	
//	public Region getRegionByPays(Pays pays) {
//		return depotregion.findByPays(pays).orElse(null);
//	}
	
	public String supprimerRegion(long id) {
		depotregion.deleteById(id);
		return "Region "+id+" supprimé avec succès!";
	}
	
	public Region modifierRegion(Region region) {
		Region regionExistant=depotregion.findById(region.getId()).orElse(null);
		regionExistant.setCoderegion(region.getCoderegion());
		regionExistant.setDomaine_activite(region.getDomaine_activite());
		regionExistant.setLangue(region.getLangue());
		regionExistant.setNb_habitant(region.getNb_habitant());
		regionExistant.setNom(region.getNom());
		regionExistant.setPays(region.getPays());
		regionExistant.setSuperficie(region.getSuperficie());
		return depotregion.save(regionExistant);
	}
	
}
