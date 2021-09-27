package br.com.zupacademy.carlos.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carlos.casadocodigo.controllers.components.GaranteNomeUnicoValidator;
import br.com.zupacademy.carlos.casadocodigo.controllers.forms.CategoriaForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;
import br.com.zupacademy.carlos.casadocodigo.repositories.CategoriaRepositorio;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired private GaranteNomeUnicoValidator garanteNomeUnicoValidator;
	
	@InitBinder
	public void configuracoesIniciais(WebDataBinder binder) {
		binder.addValidators(garanteNomeUnicoValidator);
	}
	
	@PostMapping
	public void novaCategoria(@RequestBody @Valid CategoriaForm categoria) {
		Categoria novaCategoria = categoria.converter();
		
		categoriaRepositorio.save(novaCategoria);
	}
}
