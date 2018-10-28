package com.banque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banque.dao.ClientRepository;
import com.banque.dao.CompteRepository;
import com.banque.domaine.Client;
import com.banque.domaine.CompteCourant;
import com.banque.domaine.CompteEpargne;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner{

	@Autowired
	CompteRepository compteRepository;
	@Autowired
	ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.getOne(1L);
		Client c2 = clientRepository.getOne(2L);
		
		CompteCourant cc1 = new CompteCourant();
		cc1.setClient(c1);
		cc1.setCodeCompte("cc1");
		cc1.setSolde(1000L);
		cc1.setDateCreation(new Date());
		cc1.setDecouvert(200L);
		
		CompteEpargne ce1 = new CompteEpargne();
		ce1.setClient(c1);
		ce1.setCodeCompte("ce1");
		ce1.setSolde(1000L);
		ce1.setDateCreation(new Date());
		ce1.setTaux(2L);
		
		CompteCourant cc2 = new CompteCourant();
		cc2.setClient(c2);
		cc2.setCodeCompte("cc2");
		cc2.setSolde(1000L);
		cc2.setDateCreation(new Date());
		cc2.setDecouvert(200L);
		
		compteRepository.save(cc1);
		compteRepository.save(cc2);
		compteRepository.save(ce1);

	}
}