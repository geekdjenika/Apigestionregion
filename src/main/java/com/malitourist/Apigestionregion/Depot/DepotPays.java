package com.malitourist.Apigestionregion.Depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malitourist.Apigestionregion.Modele.Pays;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotPays extends JpaRepository<Pays, Long>{
    Pays findByNom(String nom);

}
