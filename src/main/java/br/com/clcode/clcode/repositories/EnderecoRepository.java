package br.com.clcode.clcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clcode.clcode.model.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
