package br.com.zupacademy.carlos.casadocodigo.controllers.components;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.CategoriaForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;
import br.com.zupacademy.carlos.casadocodigo.repositories.CategoriaRepositorio;

@Component
public class GaranteNomeUnicoValidator implements Validator {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm formulario = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepositorio.findByNome(formulario.getNome());
		
		if(categoria.isPresent()) {
			System.out.println(categoria.get().getNome());
			errors.rejectValue("nome", null, "Alguém ja realizou um cadastro com este nome: " + formulario.getNome());
		}
	}

}
