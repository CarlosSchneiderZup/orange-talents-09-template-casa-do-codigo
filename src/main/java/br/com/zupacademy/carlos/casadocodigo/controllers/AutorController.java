package br.com.zupacademy.carlos.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.AutorForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Autor;
import br.com.zupacademy.carlos.casadocodigo.repositories.AutorRepositorio;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepositorio autorRepositorio;

	@PostMapping
	public void novoAutor(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.converter();
		autorRepositorio.save(autor);
	}
}
