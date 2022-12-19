package com.malitourist.Apigestionregion.Depot;

import com.malitourist.Apigestionregion.Modele.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotProfil extends JpaRepository<Profil, Integer> {
    @Query(value = "SELECT profil.id, profil.role FROM profil WHERE profil.role = :profil",nativeQuery = true)
    Profil findByProfileName(String profil);
}
