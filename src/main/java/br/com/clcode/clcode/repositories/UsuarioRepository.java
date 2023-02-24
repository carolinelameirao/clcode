package br.com.clcode.clcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clcode.clcode.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
