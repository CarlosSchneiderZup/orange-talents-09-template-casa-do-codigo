package br.com.zupacademy.carlos.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);
}
