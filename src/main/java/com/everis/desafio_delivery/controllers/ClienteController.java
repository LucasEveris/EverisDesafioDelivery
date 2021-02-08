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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public List<Cliente> list() {
		List<Cliente> clientes = clienteService.list();
		for (Cliente cliente : clientes) {
			cliente.setPedidos(null);	
		}
		return clientes;
	}

	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping(value="/{id}")
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {
		cliente.setContatos(clienteService.read(id).getContatos());
		return clienteService.save(cliente);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}

}
