package com.everis.desafio_delivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.desafio_delivery.models.Cliente;
import com.everis.desafio_delivery.models.Contato;
import com.everis.desafio_delivery.services.ClienteService;
import com.everis.desafio_delivery.services.ContatoService;

@RestController
@RequestMapping("/cliente/{clienteId}/contato")
public class ContatoController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public List<Contato> list(@PathVariable Long clienteId) throws Exception {
		try {
			Cliente cliente = clienteService.read(clienteId);
			return cliente.getContatos();
		} catch (Exception e) {
			System.out.println("Cliente não encontrado!");
			return null;
		}

	}

	@PostMapping
	public Contato create(@PathVariable Long clienteId, @RequestBody Contato contato) {
		try {
			Cliente cliente = clienteService.read(clienteId);
			contato = contatoService.save(contato);
			cliente.addContato(contato);
			clienteService.save(cliente);
			return contato;
		} catch (Exception e) {
			System.out.println("Cliente não encontrado!");
			return null;
		}
	}

	@PutMapping(value="/{contatoId}")
	public Contato update(@PathVariable Long clienteId, @PathVariable Long contatoId, @RequestBody Contato contato) {
		return contatoService.save(contato);
	}

	@DeleteMapping(value = "/{contatoId}")
	public void delete(@PathVariable Long id) {
		contatoService.delete(id);
	}
}
