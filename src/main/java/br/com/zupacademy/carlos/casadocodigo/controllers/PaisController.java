package br.com.zupacademy.carlos.casadocodigo.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.PaisForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepositorio paisRepositorio;

	@PostMapping
	public ResponseEntity<Pais> cadastraPais(@RequestBody @Valid PaisForm formulario, UriComponentsBuilder uriBuilder) {

		Pais pais = formulario.converter();
		paisRepositorio.save(pais);
		URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).body(pais);

	}
}
