package br.com.zupacademy.carlos.casadocodigo.controllers.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.carlos.casadocodigo.entities.Livro;

public class DetalheLivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int pagina;
	private String isbn;
	private LocalDate data;
	private String nomeAutor;
	private String descricaoAutor;

	public DetalheLivroDto(String titulo, String resumo, String sumario, BigDecimal preco, int pagina, String isbn,
			LocalDate data, String nomeAutor, String descricaoAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.data = data;
		this.nomeAutor = nomeAutor;
		this.descricaoAutor = descricaoAutor;
	}

	public static DetalheLivroDto converter(Livro livro) {
		return new DetalheLivroDto(livro.getTitulo(), livro.getResumo(), livro.getSumario(), livro.getPreco(),
				livro.getPaginas(), livro.getIsbn(), livro.getData(), livro.getAutor().getNome(),
				livro.getAutor().getDescricao());
	}

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

	public int getPagina() {
		return pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData() {
		return data;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

}
