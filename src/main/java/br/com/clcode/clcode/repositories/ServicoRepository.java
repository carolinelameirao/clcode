package br.com.clcode.clcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clcode.clcode.model.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
