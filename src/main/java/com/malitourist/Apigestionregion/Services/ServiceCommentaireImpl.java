package com.malitourist.Apigestionregion.Services;

import com.malitourist.Apigestionregion.Depot.DepotCommentaire;
import com.malitourist.Apigestionregion.Modele.Commentaire;
import com.malitourist.Apigestionregion.Modele.Region;

import java.util.List;

public class ServiceCommentaireImpl implements ServiceCommentaire{

    public final DepotCommentaire depotCommentaire;

    public final ServiceRegion serviceRegion;

    public ServiceCommentaireImpl(DepotCommentaire depotCommentaire, ServiceRegion serviceRegion) {
        this.depotCommentaire = depotCommentaire;
        this.serviceRegion = serviceRegion;
    }

    @Override
    public void commenter(Commentaire commentaire, int idregion) {
        Region regionacommenter = (Region) serviceRegion.getRegionById(idregion);
        regionacommenter.getCommentaires().add(commentaire);
    }

    @Override
    public void supprimer(int idcommentaire) {
        depotCommentaire.findById(idcommentaire).ifPresent(commentaireasupprimer -> depotCommentaire.deleteById(idcommentaire));

        System.out.println("Commentaire non trouvé !");
    }

    @Override
    public void modifier(Commentaire commentaire, int idcommentaire) {

        Commentaire retrievedCommentare = depotCommentaire.findById(idcommentaire).orElse(null);

        if(retrievedCommentare==null) {
            try {
                throw new Exception("Collaborateur non trouvé !");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else  {
            retrievedCommentare.setTexte(commentaire.getTexte());
        }
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return depotCommentaire.findAll();
    }

    @Override
    public List<Commentaire> getAllCommentaireByRegion(int idregion) {
        return depotCommentaire.getCommentaireByRegion(idregion);
    }

}
