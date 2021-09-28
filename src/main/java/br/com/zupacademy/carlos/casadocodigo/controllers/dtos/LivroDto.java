package br.com.zupacademy.carlos.casadocodigo.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.carlos.casadocodigo.entities.Livro;

public class LivroDto {

	private Long id;
	private String titulo;

	public LivroDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(livro -> new LivroDto(livro.getId(), livro.getTitulo()))
				.collect(Collectors.toList());
	}
}
