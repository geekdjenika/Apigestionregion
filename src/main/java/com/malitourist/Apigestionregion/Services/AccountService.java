package com.malitourist.Apigestionregion.Services;

import com.malitourist.Apigestionregion.Modele.Profil;
import com.malitourist.Apigestionregion.Modele.Utilisateur;

import java.util.List;

public interface AccountService {

    //Service pour la gestion des utilisateurs
    Utilisateur addNewUser(Utilisateur utilisateur);
    Profil addNewProfile(Profil profil);
    void addProfileToUser(String username, String profileName);
    Utilisateur loadUserByUsername(String username);
    List<Utilisateur> listUsers();

}
