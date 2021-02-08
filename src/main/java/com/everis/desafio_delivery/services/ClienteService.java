package com.everis.desafio_delivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio_delivery.models.Cliente;
import com.everis.desafio_delivery.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> list() {
		return clienteRepository.findAll();
	}

	public Cliente read(Long id) throws Exception {
		return clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não encontrado"));
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
