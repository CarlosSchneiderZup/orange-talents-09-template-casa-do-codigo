package br.com.zupacademy.carlos.casadocodigo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.carlos.casadocodigo.controllers.dtos.DetalheLivroDto;
import br.com.zupacademy.carlos.casadocodigo.entities.Livro;
import br.com.zupacademy.carlos.casadocodigo.repositories.LivroRepositorio;

@RestController
@RequestMapping("/produtos")
public class DetalheLivroController {

	@Autowired
	private LivroRepositorio livroRepositorio;

	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDto> buscaDetalhesLivro(@PathVariable Long id) {
		Optional<Livro> livro = livroRepositorio.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(DetalheLivroDto.converter(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
