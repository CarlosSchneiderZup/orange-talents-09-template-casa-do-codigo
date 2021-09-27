package br.com.zupacademy.carlos.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String resumo;
	@Column(columnDefinition = "TEXT")
	private String sumario;
	@Column(nullable = false)
	private BigDecimal preco;
	@Column(nullable = false)
	private Integer paginas;
	@Column(nullable = false, unique = true)
	private String isbn;
	private LocalDate data;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Autor autor;

	public Livro() {}
	
	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
			LocalDate data, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.data = data;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
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

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData() {
		return data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
