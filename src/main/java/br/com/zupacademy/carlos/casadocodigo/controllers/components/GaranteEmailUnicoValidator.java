package br.com.zupacademy.carlos.casadocodigo.controllers.components;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.AutorForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Autor;
import br.com.zupacademy.carlos.casadocodigo.repositories.AutorRepositorio;

@Component
public class GaranteEmailUnicoValidator implements Validator{

	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm formulario = (AutorForm) target;
		Optional<Autor> autor = autorRepositorio.findByEmail(formulario.getEmail());
		
		if(autor.isPresent()) {
			errors.rejectValue("email", null, "Alguém ja realizou um cadastro com este email: " + formulario.getEmail());
		}
	}

}
