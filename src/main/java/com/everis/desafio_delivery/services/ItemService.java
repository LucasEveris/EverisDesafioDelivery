package com.everis.desafio_delivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio_delivery.models.Item;
import com.everis.desafio_delivery.repositories.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> list()  {
		return itemRepository.findAll();
	}

	public Item read(Long id) throws Exception {
		return itemRepository.findById(id).orElseThrow(() -> new Exception("Item não encontrado"));
	}
	
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
