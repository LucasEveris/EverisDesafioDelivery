package com.everis.desafio_delivery.models.dto.request;

import java.util.List;

import com.everis.desafio_delivery.models.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoRequestDTO {

	private Long pedidoId;
	private Long clienteId;
	
	private List<Item> itens; 
	
}
