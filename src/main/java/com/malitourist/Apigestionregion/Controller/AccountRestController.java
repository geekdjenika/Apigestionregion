package com.malitourist.Apigestionregion.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malitourist.Apigestionregion.Modele.Profil;
import com.malitourist.Apigestionregion.Modele.RoleUserModel;
import com.malitourist.Apigestionregion.Modele.Utilisateur;
import com.malitourist.Apigestionregion.Services.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Pour retrouver tous les utilisateurs
    @GetMapping("/users")
    @PostAuthorize("hasAuthority('USER')")
    public List<Utilisateur> utilisateurs() {
        return accountService.listUsers();
    }

    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users")
    Utilisateur saveUser(@RequestBody Utilisateur utilisateur) {
        return accountService.addNewUser(utilisateur);
    }

    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/roles")
    Profil saveProfile(@RequestBody Profil profil) {
        return accountService.addNewProfile(profil);
    }

    @PostMapping("/addprofiletouser")
    @PostAuthorize("hasAuthority('ADMIN')")
    void addProfileToUser(@RequestBody RoleUserModel roleUserModel) {
        accountService.addProfileToUser(roleUserModel.getUsername(), roleUserModel.getProfilename());
    }

    //Méthode pour rafraichir le token
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authToken = request.getHeader("Authoriation");
        if (authToken != null && authToken.startsWith("Bearer ")) {
            String jwt = authToken.substring(7);
            Algorithm algorithm = Algorithm.HMAC256("__inc0nnu__");
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
            String username = decodedJWT.getSubject();

            //Chercher l'utilisateur dans la base de données
            Utilisateur utilisateur = accountService.loadUserByUsername(username);

            //AccesToken
            String jwtAccessToken = JWT.create()
                    .withSubject(utilisateur.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("profils",utilisateur.getProfils().stream().map(Profil::getRole).collect(Collectors.toList()))
                    .  sign(algorithm);

            //Mettre la réponse dans un body / Envoyer le token
            Map<String, String> idToken = new HashMap<>();
            idToken.put("access-token", jwtAccessToken);
            idToken.put("refresh-token", jwt);
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(),idToken);

        } else {
            throw new RuntimeException("Veiller fournir un refresh token");
        }
    }
}
