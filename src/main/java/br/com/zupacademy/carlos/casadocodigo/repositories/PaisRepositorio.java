package br.com.zupacademy.carlos.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {

	Optional<Estado> findByEstadosId(Long idEstado);
	Optional<Estado> findByEstadosNome(String nomeEstado);
}
