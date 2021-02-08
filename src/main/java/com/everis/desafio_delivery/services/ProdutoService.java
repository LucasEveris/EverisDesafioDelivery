package com.everis.desafio_delivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio_delivery.models.Produto;
import com.everis.desafio_delivery.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> list()  {
		return produtoRepository.findAll();
	}

	public Produto read(Long id) throws Exception {
		return produtoRepository.findById(id).orElseThrow(() -> new Exception("Produto não encontrado"));
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
}
