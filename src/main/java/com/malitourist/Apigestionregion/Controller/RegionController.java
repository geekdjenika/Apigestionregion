package com.malitourist.Apigestionregion.Controller;

import com.malitourist.Apigestionregion.Exception.Message;
import com.malitourist.Apigestionregion.Modele.Region;
import com.malitourist.Apigestionregion.Services.ServiceRegion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "Cette API permettra de controller les regions")
public class RegionController {
    @Autowired
    public ServiceRegion serviceregion;

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
    public Object ajouterRegion(Region region) {

        try {
            return serviceregion.ajouterRegion(region);
        } catch (Exception e) {
            return Message.ErreurReponse("Cette région existe déjà !", HttpStatus.OK);
        }

    }

    @ApiOperation(value = "Cette requette permet de modifier une region donnnée")
    @PutMapping(value = "modifier_region/{coderegion}")
    public String modifierRegion(Region region) {
        return serviceregion.modifierRegion(region);
    }

    @ApiOperation(value = "Cette requette permet de supprimer une region donnnée")
    @DeleteMapping(value = "/supprimer_region/{id}")
    public String supprimerRegion(@PathVariable long id) {
        return serviceregion.supprimerRegion(id);
    }
}
