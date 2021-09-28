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

import br.com.zupacademy.carlos.casadocodigo.controllers.forms.EstadoForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.repositories.EstadoRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepositorio estadoRepositorio;
	@Autowired
	private PaisRepositorio paisRepositorio;

	@PostMapping
	public ResponseEntity<Estado> cadastraEstado(@RequestBody @Valid EstadoForm formulario,
			UriComponentsBuilder uriBuilder) {

		Estado estado = formulario.converter(paisRepositorio);
		estadoRepositorio.save(estado);

		URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(estado);
	}
}
