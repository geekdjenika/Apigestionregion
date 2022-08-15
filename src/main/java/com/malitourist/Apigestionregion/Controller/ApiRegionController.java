package com.malitourist.Apigestionregion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.malitourist.Apigestionregion.Modele.Habitant;
import com.malitourist.Apigestionregion.Modele.Pays;
import com.malitourist.Apigestionregion.Modele.Region;
import com.malitourist.Apigestionregion.Services.ServiceHabitant;
import com.malitourist.Apigestionregion.Services.ServicePays;
import com.malitourist.Apigestionregion.Services.ServiceRegion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "hello", description = "Cette API permettra de faire la gestion des régions de mon pays(Mali)")
public class ApiRegionController {
	@Autowired
	public ServiceRegion serviceregion;
	
	@Autowired
	public ServicePays servicepays;
	
	@Autowired
	public ServiceHabitant servicehabitant;
	
	@ApiOperation(value = "Bienvenu à la page de test de notre api de Gestion des régions")
	@RequestMapping("/")
	public String getPage() {

		return "Bienvenue" ;
	}
	@ApiOperation(value = "Cette requette permet d'afficher la liste des regions avec pays")
	@GetMapping(value = "/region")
	public List<Region> getRegions() {

		return serviceregion.getRegion();
	}
	
	@ApiOperation(value = "Cette requette permet d'afficher la liste des regions sans pays")
	@GetMapping(value = "/regionsanspays")
	public Iterable<Object[]> getRegionssanspays() {

		return serviceregion.getRegionsanspays();
	}
	
	@ApiOperation(value = "Cette requette permet d'ajouter une region à la liste des régions")
	@PostMapping(value = "/ajouter_region")
	 public Region ajouterRegion(@RequestBody Region region) {
		
		return serviceregion.ajouterRegion(region);
	}
	
    @ApiOperation(value = "Cette requette permet de modifier une region donnnée")
	@PutMapping(value = "modifier_region/{coderegion}")
	 public Region modifierRegion(@RequestBody Region region) {

		return serviceregion.modifierRegion(region);
	}
	
    /*-------Controller qui permet de supprimer une région grâce à son id--------*/
    @ApiOperation(value = "Cette requette permet de supprimer une region donnnée")
	@DeleteMapping(value = "/supprimer_region/{id}")
	public String supprimerRegion(@PathVariable long id) {
		return serviceregion.supprimerRegion(id);
	}
	
    /*-------Controller qui affiche la liste des pays--------*/
    @ApiOperation(value = "Cette requette permet d'afficher la liste des pays")
	@GetMapping(value = "/pays")
	public List<Pays> getPays() {
		return servicepays.getPays();
	}
	
    /*-------Controller qui ajoute un pays à la liste des pays--------*/
    @ApiOperation(value = "Cette requette permet d'ajouter un pays")
	@PostMapping(value = "/ajouter_pays")
	 public Pays ajouterPays(@RequestBody Pays pays) {
		
		return servicepays.ajouterPays(pays);
	}
//    @ApiOperation(value = "Just to test the sample test api of My App Service")
//	@DeleteMapping(value = "/supprimer_pays/{id_pays}")
//	public String supprimerPays(@PathVariable long id) {
//		return servicehabitant.supprimerHabitant(id);
//	}
	
    /*-------Controller qui affiche le nombre d'habitant en fonction de l'année--------*/
    @ApiOperation(value = "Cette requette permet d'afficher la liste des nombres d'habitant en fonction de l'année")
	@GetMapping(value = "/habitant")
	public List<Habitant> getHabitant() {

		return servicehabitant.getHabitant();
	}
    
    /*-------Controller qui ajoute le nombre d'habitant en fonction de l'année--------*/
    @ApiOperation(value = "Cette requette permet d'ajouter des nbre d'habitants")
	@PostMapping(value = "/ajouter_habitant")
	 public Habitant ajouterHabitant(@RequestBody Habitant habitant) {
		
		return servicehabitant.ajouterHabitant(habitant);
	}
    
//    @ApiOperation(value = "Cette requette permet de supprimer un nombre d'habitant")
//	@DeleteMapping(value = "/supprimer_habitant/{id_hbtant}")
//	public String supprimerHabitant(@PathVariable long id) {
//		return servicehabitant.supprimerHabitant(id);
//	}
	
//	@PostMapping(value = "/ajouter_pays")
//	public String ajouterPays(@RequestBody Pays pays) {
//		depotpays.save(pays);
//		return "Pays ajouté avec succès!";
//	}
	
	
	
}
