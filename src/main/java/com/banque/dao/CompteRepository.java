package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.domaine.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
