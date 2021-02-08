package com.everis.desafio_delivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio_delivery.models.Contato;
import com.everis.desafio_delivery.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}
	
	public List<Contato> list()  {
		return contatoRepository.findAll();
	}

	public Contato read(Long id) throws Exception {
		return contatoRepository.findById(id).orElseThrow(() -> new Exception("Contato não encontrado"));
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
}
