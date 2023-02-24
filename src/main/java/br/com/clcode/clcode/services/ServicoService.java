package br.com.clcode.clcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clcode.clcode.model.entities.Servico;
import br.com.clcode.clcode.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> findAll() {
		return repository.findAll();
	}
	
	public Servico findById(Long id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.get();
	}
	
	public Servico insert(Servico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Servico update(Long id, Servico obj) {
		Servico entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Servico entity, Servico obj) {
		entity.setTipo(obj.getTipo());
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());
	}
}
