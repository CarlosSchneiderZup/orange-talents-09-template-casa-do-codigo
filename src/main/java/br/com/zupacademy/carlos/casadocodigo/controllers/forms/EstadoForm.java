package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

public class EstadoForm {

	@NotBlank
	private String nome;
	@NotNull
	private Long idPais;

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado converter(PaisRepositorio paisRepositorio) {

		Optional<Pais> pais = paisRepositorio.findById(idPais);
		if (pais.isPresent()) {
			return new Estado(nome, pais.get());
		}
		return null;
	}
}
