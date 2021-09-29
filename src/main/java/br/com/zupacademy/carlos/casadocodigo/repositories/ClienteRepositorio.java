package br.com.zupacademy.carlos.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carlos.casadocodigo.entities.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
