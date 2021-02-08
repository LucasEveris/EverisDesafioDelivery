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

import com.everis.desafio_delivery.models.Item;
import com.everis.desafio_delivery.services.ItemService;
import com.everis.desafio_delivery.services.ProdutoService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Item> list() {
		return itemService.list();
	}

	@PostMapping
	public Item create(@RequestBody Item item) {
		return itemService.save(item);
	}
	
	@PutMapping
	public Item update(@RequestBody Item item) {
		return itemService.save(item);
	} 
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable Long id) {
		itemService.delete(id);
	}
}
