package com.everis.desafio_delivery.services;

import java.util.List;

import com.everis.desafio_delivery.models.Item;

public class DeliveryService {

	public Double calculaPrecoPedido(List<Item> itens) {
		
		Double valorTotal = 0.0;
		for (Item item : itens) {
			valorTotal += item.getProduto().getPreco() * item.getQuantidadeProdutos();
		
		}
		
		return valorTotal;
	}
}
