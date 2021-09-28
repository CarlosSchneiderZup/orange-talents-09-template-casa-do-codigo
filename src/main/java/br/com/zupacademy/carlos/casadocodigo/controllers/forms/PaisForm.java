package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.carlos.casadocodigo.customizations.UniqueValue;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;

public class PaisForm {

	@NotBlank 
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
}
