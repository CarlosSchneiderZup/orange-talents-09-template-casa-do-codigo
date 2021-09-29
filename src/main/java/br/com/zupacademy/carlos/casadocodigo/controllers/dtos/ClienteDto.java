package br.com.zupacademy.carlos.casadocodigo.controllers.dtos;

import br.com.zupacademy.carlos.casadocodigo.entities.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome() + " " + cliente.getSobrenome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
