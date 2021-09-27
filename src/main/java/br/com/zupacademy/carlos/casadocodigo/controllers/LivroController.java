package br.com.zupacademy.carlos.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.LivroForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Livro;
import br.com.zupacademy.carlos.casadocodigo.repositories.AutorRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.CategoriaRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.LivroRepositorio;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepositorio livroRepositorio;
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid LivroForm livro) {
		Livro novoLivro = livro.converter(categoriaRepositorio, autorRepositorio);
		
		livroRepositorio.save(novoLivro);
	}
}
