package com.malitourist.Apigestionregion.Controller;

import com.malitourist.Apigestionregion.Modele.Habitant;
import com.malitourist.Apigestionregion.Services.ServiceHabitant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "hello", description = "Cette API permettra de faire la gestion des régions de mon pays(Mali)")
public class HabitantController {
    @Autowired
    public ServiceHabitant servicehabitant;

    /*-------Controller qui affiche le nombre d'habitant en fonction de l'année--------*/
    @ApiOperation(value = "Cette requette permet d'afficher la liste des nombres d'habitant en fonction de l'année")
    @GetMapping(value = "/habitant")
    public List<Habitant> getHabitant() {
        return servicehabitant.getHabitant();
    }

    /*-------Controller qui ajoute le nombre d'habitant en fonction de l'année--------*/
    @ApiOperation(value = "Cette requette permet d'ajouter des nbre d'habitants")
    @PostMapping(value = "/ajouter_habitant")
    public Habitant ajouterHabitant(Habitant habitant) {

        return servicehabitant.ajouterHabitant(habitant);
    }

}
