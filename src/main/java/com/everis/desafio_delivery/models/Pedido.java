package com.everis.desafio_delivery.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item_id")
	private List<Item> itens;
	
	public void addItem(Item item) {
		this.itens.add(item);
	}
	
	public void removeItem(Item item) {
		if (this.itens.contains(item)) { 
			this.itens.remove(item);
		}
	}
	
}
