package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.carlos.casadocodigo.customizations.UniqueValue;
import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}
}
