package br.com.zupacademy.carlos.casadocodigo.controllers.components;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.ClienteForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;
import br.com.zupacademy.carlos.casadocodigo.repositories.EstadoRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

@Component
public class GaranteEstadoPertenceAPaisValidator implements Validator {

	@Autowired
	private PaisRepositorio paisRepositorio;
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}

		ClienteForm request = (ClienteForm) target;

		Pais pais = paisRepositorio.findById(request.getIdPais()).get();
		
		if (request.getIdEstado() != null) {
			Optional<Estado> estado = estadoRepositorio.findById(request.getIdEstado());
			if (estado.isPresent()) {
				boolean estadoValido = pais.verificaValidadeEstado(estado.get().getNome());
				if (!estadoValido) {
					errors.rejectValue("idEstado",null,"este estado não pertence ao país selecionado");
				}
			}
		}
	}
}
