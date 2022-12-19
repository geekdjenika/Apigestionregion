package com.malitourist.Apigestionregion.Controller;

import com.malitourist.Apigestionregion.Exception.Message;
import com.malitourist.Apigestionregion.Modele.Pays;
import com.malitourist.Apigestionregion.Services.ServicePays;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "hello", description = "Cette API permettra de faire la gestion des régions de mon pays(Mali)")
public class PaysController {
    public final ServicePays servicepays;

    public PaysController(ServicePays servicepays) {
        this.servicepays = servicepays;
    }

    @ApiOperation(value = "Cette requette permet d'ajouter un pays")
    @PostMapping(value = "/ajouter_pays")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Object ajouterPays(Pays pays) {

        try {
            return servicepays.ajouterPays(pays);
        }catch (Exception e){
            return Message.ErreurReponse("Le pays "+pays.getNom()+ " existe déjà", HttpStatus.OK);
        }

    }

    @ApiOperation(value = "Cette requette permet d'afficher la liste des pays")
    @GetMapping(value = "/pays")
    @PostAuthorize("hasAuthority('USER')")
    public List<Pays> getPays() {
        return servicepays.getPays();
    }


}
