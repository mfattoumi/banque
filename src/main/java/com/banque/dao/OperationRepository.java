package com.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banque.domaine.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

}
