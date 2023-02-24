package br.com.clcode.clcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clcode.clcode.model.entities.Endereco;
import br.com.clcode.clcode.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Endereco findByid(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
	
	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Endereco update(Long id, Endereco obj) {
		Endereco entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Endereco entity, Endereco obj) {
		entity.setLogradouro(obj.getLogradouro());
		entity.setNumero(obj.getNumero());
		entity.setComplemento(obj.getComplemento());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setCep(obj.getCep());
	}
}