package com.malitourist.Apigestionregion;

import com.malitourist.Apigestionregion.Depot.DepotProfil;
import com.malitourist.Apigestionregion.Modele.Profil;
import com.malitourist.Apigestionregion.Modele.Utilisateur;
import com.malitourist.Apigestionregion.Services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class ApigestionregionApplication {

	final
	DepotProfil depotProfil;

	public ApigestionregionApplication(DepotProfil depotProfil) {
		this.depotProfil = depotProfil;
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new  WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(AccountService accountService) {

		return args -> {

			//Ajout des rôles
			if (depotProfil.findAll().size() == 0) {
				accountService.addNewProfile(new Profil(null,"USER"));
				accountService.addNewProfile(new Profil(null,"ADMIN"));
			}

			//Ajout des utilisateur initiales
			if (accountService.listUsers().size() == 0) {
				accountService.addNewUser(new Utilisateur(null,"geekdjenika","inconnu",new ArrayList<>()));
				//Attribution du rôle de geekdjenika
				accountService.addProfileToUser("geekdjenika","ADMIN");

				accountService.addNewUser(new Utilisateur(null,"mamdy017","mamdy",new ArrayList<>()));
				//Attribution du rôle de mamdy017
				accountService.addProfileToUser("mamdy017","USER");

				accountService.addNewUser(new Utilisateur(null,"aoua1414","aoua1414",new ArrayList<>()));
				//Attribution du rôle de aoua1414
				accountService.addProfileToUser("aoua1414","USER");

			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApigestionregionApplication.class, args);
	}

}
