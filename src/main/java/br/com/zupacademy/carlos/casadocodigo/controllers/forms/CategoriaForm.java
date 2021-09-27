package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;

public class CategoriaForm {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}
}
