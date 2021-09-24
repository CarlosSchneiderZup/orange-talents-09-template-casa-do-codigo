package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.carlos.casadocodigo.entities.Autor;

public class AutorForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@Length(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
