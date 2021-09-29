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

import br.com.zupacademy.carlos.casadocodigo.controllers.dtos.ClienteDto;
import br.com.zupacademy.carlos.casadocodigo.controllers.forms.ClienteForm;
import br.com.zupacademy.carlos.casadocodigo.entities.Cliente;
import br.com.zupacademy.carlos.casadocodigo.repositories.ClienteRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.EstadoRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private PaisRepositorio paisRepositorio;
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastraCliente(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		
		Cliente cliente = form.converter(paisRepositorio, estadoRepositorio);
		clienteRepositorio.save(cliente);
		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
}
