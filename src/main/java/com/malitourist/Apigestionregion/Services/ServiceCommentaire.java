package com.malitourist.Apigestionregion.Services;

import com.malitourist.Apigestionregion.Modele.Commentaire;

import java.util.List;

public interface ServiceCommentaire {

    void commenter(Commentaire commentaire, int idregion);

    void supprimer(int idcommentaire);
    void modifier(Commentaire commentaire, int idcommentaire);

    List<Commentaire> getAllCommentaire();

    List<Commentaire> getAllCommentaireByRegion(int idregion);
}
