package br.com.zupacademy.carlos.casadocodigo.controllers.components;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.EstadoForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

@Component
public class GaranteEstadoUnicoPorPaisValidator implements Validator {

	@Autowired
	private PaisRepositorio paisRepositorio;

	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		EstadoForm formulario = (EstadoForm) target;
		Optional<Pais> pais = paisRepositorio.findById(formulario.getIdPais());

		if (pais.isPresent()) {
			List<Estado> estados = pais.get().getEstados();

			for (Estado estado : estados) {
				if (formulario.getNome().equals(estado.getNome())) {
					errors.rejectValue("nome", null,
							"Alguém ja realizou um cadastro deste estado para o país em questão.");
				}
			}
		}
	}

}
