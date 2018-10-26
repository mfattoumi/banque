package com.banque.service;

import org.springframework.data.domain.Page;

import com.banque.domaine.Compte;
import com.banque.domaine.Operation;

public interface IBanqueService {
	
	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public void virement(String codeCompte1, String codeCompte2, double montant);
	public Page<Operation> listOperation(String codeCompte, int page, int size);

}
