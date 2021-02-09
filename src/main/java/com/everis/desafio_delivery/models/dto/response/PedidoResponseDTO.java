package com.everis.desafio_delivery.models.dto.response;

import java.util.List;

import com.everis.desafio_delivery.enums.FormaDePagamento;
import com.everis.desafio_delivery.models.Item;
import com.everis.desafio_delivery.models.Pedido;
import com.everis.desafio_delivery.services.DeliveryService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoResponseDTO {

	private Long pedidoId;
	private Long clienteId;
	private List<Item> itens;
	private Double precoFinal;
	private FormaDePagamento formaDePagamento; // ENUM AQUI

	public PedidoResponseDTO(Pedido pedido) {
		this.pedidoId = pedido.getId();
		this.clienteId = pedido.getCliente().getId();
		this.itens = pedido.getItens();
		this.precoFinal = new DeliveryService().calculaPrecoPedido(this.itens);
		this.formaDePagamento = pedido.getFormaDePagamento(); // ENUM AQUI
	}


}
