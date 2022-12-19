package com.malitourist.Apigestionregion.Services;

import com.malitourist.Apigestionregion.Depot.DepotProfil;
import com.malitourist.Apigestionregion.Depot.DepotUtilisateur;
import com.malitourist.Apigestionregion.Modele.Profil;
import com.malitourist.Apigestionregion.Modele.Utilisateur;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@ToString
public class AccountServiceImpl implements AccountService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    DepotUtilisateur depotUtilisateur;
    @Autowired
    DepotProfil depotProfil;


    @Override
    public Utilisateur addNewUser(Utilisateur utilisateur) {
        String pw = utilisateur.getPassword();
        utilisateur.setPassword(passwordEncoder.encode(pw));
        return depotUtilisateur.save(utilisateur);
    }

    @Override
    public Profil addNewProfile(Profil profil) {
        return depotProfil.save(profil);
    }

    @Override
    public void addProfileToUser(String username, String profileName) {

        Utilisateur utilisateur = depotUtilisateur.findByUserName(username);
        Profil profil = depotProfil.findByProfileName(profileName);

        System.out.println("Voici l'utilisateur voulu : "+utilisateur+" son username est : "+username);
        System.out.println("Voici le profil voulu : "+profil+" sa clé de recherche est : "+username);

        utilisateur.getProfils().add(profil);

    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return depotUtilisateur.findByUserName(username);
    }

    @Override
    public List<Utilisateur> listUsers() {
        return depotUtilisateur.findAll();
    }
}
