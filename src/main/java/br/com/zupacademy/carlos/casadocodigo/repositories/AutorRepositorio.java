package br.com.zupacademy.carlos.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Autor;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

}
