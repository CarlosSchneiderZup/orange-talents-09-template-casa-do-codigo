package br.com.zupacademy.carlos.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Livro;

public interface LivroRepositorio  extends JpaRepository<Livro, Long>{

}
