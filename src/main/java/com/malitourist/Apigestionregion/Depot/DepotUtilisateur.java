package com.malitourist.Apigestionregion.Depot;

import com.malitourist.Apigestionregion.Modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotUtilisateur extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "SELECT utilisateur.id, utilisateur.username, utilisateur.password FROM utilisateur WHERE utilisateur.username = :username",nativeQuery = true)
    Utilisateur findByUserName(String username);
}
