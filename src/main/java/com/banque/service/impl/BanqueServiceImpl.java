package com.banque.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.dao.CompteRepository;
import com.banque.dao.OperationRepository;
import com.banque.domaine.Compte;
import com.banque.domaine.CompteCourant;
import com.banque.domaine.Operation;
import com.banque.domaine.Retrait;
import com.banque.domaine.Versement;
import com.banque.service.IBanqueService;

@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService{

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCompte) {
		Compte resultat = compteRepository.getOne(codeCompte);
		if(resultat==null) {
			throw new RuntimeException("Compte introuvable");
		}
		return resultat;
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Compte compte = consulterCompte(codeCompte);
		Versement versement = new Versement(new Date(), montant, compte);
		operationRepository.save(versement);
		compte.setSolde(compte.getSolde()+montant);
		compteRepository.save(compte);
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte compte = consulterCompte(codeCompte);
		double faciliteCaisse=0;
		if(compte instanceof CompteCourant) {
			faciliteCaisse = ((CompteCourant)compte).getDecouvert();
		}
		if(compte.getSolde()+faciliteCaisse < montant) {
			throw new RuntimeException("Solde insuffisant");
		}
		Retrait retrait = new Retrait(new Date(), montant, compte);
		operationRepository.save(retrait);
		compte.setSolde(compte.getSolde()-montant);
		compteRepository.save(compte);
	}

	@Override
	public void virement(String codeCompte1, String codeCompte2, double montant) {
		retirer(codeCompte1, montant);	
		verser(codeCompte2, montant);
	}

	@Override
	public Page<Operation> listOperation(String codeCompte, int page, int size) {
		return operationRepository.listOperation(codeCompte, new PageRequest(page, size));
	}

}
