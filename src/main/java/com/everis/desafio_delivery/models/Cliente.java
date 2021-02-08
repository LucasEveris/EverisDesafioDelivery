package com.everis.desafio_delivery.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cpf")
	private String cpf;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "contato_id")
	private List<Contato> contatos;

	@OneToMany(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "pedido_id")
	private List<Pedido> pedidos;

	public void addContato(Contato contato) {
		if (!this.contatos.contains(contato)) {
			this.contatos.add(contato);
		}
	}

	public void removeContato(Contato contato) {
		if (this.contatos.contains(contato)) {
			this.contatos.remove(contato);
		}
	}

	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public void removePedido(Pedido pedido) {
		if (this.pedidos.contains(pedido)) {
			this.pedidos.remove(pedido);
		}
	}

}
