package br.com.zupacademy.carlos.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
}
