package br.com.clcode.clcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clcode.clcode.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
