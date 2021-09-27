package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.carlos.casadocodigo.customizations.UniqueValue;
import br.com.zupacademy.carlos.casadocodigo.entities.Autor;
import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;
import br.com.zupacademy.carlos.casadocodigo.entities.Livro;
import br.com.zupacademy.carlos.casadocodigo.repositories.AutorRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.CategoriaRepositorio;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Integer paginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate data;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idAutor;

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData() {
		return data;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Livro converter(CategoriaRepositorio categoriaRepositorio, AutorRepositorio autorRepositorio) {
		Optional<Categoria> categoria = categoriaRepositorio.findById(idCategoria);
		Optional<Autor> autor = autorRepositorio.findById(idAutor);

		if (categoria.isPresent() && autor.isPresent()) {
			return new Livro(titulo, resumo, sumario, preco, paginas, isbn, data, categoria.get(), autor.get());
		}

		return null;
	}
}
