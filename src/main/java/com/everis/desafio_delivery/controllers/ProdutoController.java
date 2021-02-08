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

import com.everis.desafio_delivery.models.Produto;
import com.everis.desafio_delivery.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> list() {
		return produtoService.list();
	}

	@PostMapping
	public Produto create(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	@PutMapping
	public Produto update(@RequestBody Produto produto) {
		return produtoService.save(produto);
	} 
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable Long id) {
		produtoService.delete(id);
	}
}
