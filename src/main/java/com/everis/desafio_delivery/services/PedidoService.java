package com.everis.desafio_delivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio_delivery.models.Pedido;
import com.everis.desafio_delivery.repositories.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> list()  {
		return pedidoRepository.findAll();
	}
	
	// dando problema(?)
	public Pedido read(Long id) throws Exception {
		return pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido não encontrado"));
	}
	
	public void delete(Long id) {
		pedidoRepository.deleteById(id);
	}
	
}
