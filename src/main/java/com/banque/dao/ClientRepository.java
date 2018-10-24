package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.domaine.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
