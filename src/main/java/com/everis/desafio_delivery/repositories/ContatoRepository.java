package com.everis.desafio_delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.desafio_delivery.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
}
