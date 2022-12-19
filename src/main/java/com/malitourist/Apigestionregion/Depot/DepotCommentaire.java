package com.malitourist.Apigestionregion.Depot;

import com.malitourist.Apigestionregion.Modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepotCommentaire extends JpaRepository<Commentaire, Integer> {
    @Query(value = "SELECT c FROM commentaire AS c, Region AS r, utilisateur u" +
            "LEFT JOIN regioncommentee AS rc " +
            "ON c.regioncommentee = rc.id " +
            "LEFT JOIN createur AS cc " +
            "ON c.createur = cc.id " +
            "WHERE r.id = :idregion", nativeQuery = true)
    List<Commentaire> getCommentaireByRegion(int idregion);
}
