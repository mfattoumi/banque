package com.banque;

import org.springframework.context.ApplicationContext;

import com.banque.dao.ClientRepository;
import com.banque.domaine.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("client1","email1@gmail.com"));
		Client c2 = clientRepository.save(new Client("client2","email1@gmail.com"));
	}
}
