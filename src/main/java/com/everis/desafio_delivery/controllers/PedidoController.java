package com.everis.desafio_delivery.controllers;

import java.util.ArrayList;
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
import com.everis.desafio_delivery.models.Item;
import com.everis.desafio_delivery.models.Pedido;
import com.everis.desafio_delivery.models.dto.request.PedidoRequestDTO;
import com.everis.desafio_delivery.models.dto.response.PedidoResponseDTO;
import com.everis.desafio_delivery.repositories.ItemRepository;
import com.everis.desafio_delivery.services.ClienteService;
import com.everis.desafio_delivery.services.ItemService;
import com.everis.desafio_delivery.services.PedidoService;
import com.everis.desafio_delivery.services.ProdutoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<PedidoResponseDTO> list() {
		List<PedidoResponseDTO> pedidosResponseDto = new ArrayList<PedidoResponseDTO>();
		for (Pedido pedido : pedidoService.list()) {
			pedidosResponseDto.add(new PedidoResponseDTO(pedido));
		}
		return pedidosResponseDto;
	}

	@GetMapping(value = "/{pedidoId}")
	public PedidoResponseDTO listPorId(@PathVariable Long pedidoId) throws Exception {
		PedidoResponseDTO pedidoResponseDto = new PedidoResponseDTO(pedidoService.read(pedidoId));
		return pedidoResponseDto;
	}

	@GetMapping(value = "/cliente/{clienteId}")
	public List<Pedido> listPorCliente(@PathVariable Long clienteId) {
		try {
			Cliente cliente = clienteService.read(clienteId);
			List<Pedido> pedidos = cliente.getPedidos();
			for (Pedido pedido : pedidos) {
				pedido.setCliente(null);
			}
			return pedidos;
		} catch (Exception e) {
			System.out.println("Cliente não encontrado!");
			return null;
		}
	}

	@PostMapping(value = "/cliente/{clienteId}")
	public PedidoResponseDTO create(@PathVariable Long clienteId, @RequestBody PedidoRequestDTO pedidoDto) throws Exception {
		try {
			Cliente cliente = clienteService.read(clienteId);
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente); // try catch verificando contato do cliente
			try {
				List<Item> itensDoPedido = pedidoDto.getItens();
				List<Item> itensComProdutos = new ArrayList<>();
				
				for (Item item : itensDoPedido) {
					item.setProduto(produtoService.read(item.getProduto().getId()));
					itensComProdutos.add(itemService.save(item));
				}
				pedido.setItens(itensComProdutos);
				pedido = pedidoService.save(pedido);
				
				cliente.addPedido(pedido);
				clienteService.save(cliente);

				return new PedidoResponseDTO(pedido);
			} catch (Exception e) {
				System.out.println("Produto não encontrado!");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Cliente não encontrado!");
			return null;
		}

	}

	@PutMapping(value = "/{id}")
	public Pedido update(@RequestBody PedidoRequestDTO pedidoDto) {
		// remontar o Pedido e salvar -- igual o post
		return pedidoService.save(new Pedido());
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		pedidoService.delete(id);
	}
}
