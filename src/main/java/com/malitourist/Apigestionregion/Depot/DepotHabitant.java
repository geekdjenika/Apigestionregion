package com.malitourist.Apigestionregion.Depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malitourist.Apigestionregion.Modele.Habitant;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotHabitant extends JpaRepository<Habitant, Long>{

}
