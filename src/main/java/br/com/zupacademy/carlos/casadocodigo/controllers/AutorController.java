package br.com.zupacademy.carlos.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carlos.casadocodigo.controllers.components.GaranteEmailUnicoValidator;
import br.com.zupacademy.carlos.casadocodigo.controllers.forms.AutorForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Autor;
import br.com.zupacademy.carlos.casadocodigo.repositories.AutorRepositorio;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepositorio autorRepositorio;
	@Autowired
	private GaranteEmailUnicoValidator garanteEmailUnicoValidator;
	
	@InitBinder
	public void configuracoesIniciais(WebDataBinder binder) {
		binder.addValidators(garanteEmailUnicoValidator);
	}

	@PostMapping
	public ResponseEntity<Autor> novoAutor(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {
		Autor autor = autorForm.converter();
		
			autorRepositorio.save(autor);
			URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
			return ResponseEntity.created(uri).body(autor);
	}
}
