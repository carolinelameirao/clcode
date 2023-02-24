package br.com.clcode.clcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clcode.clcode.model.entities.OrdemServico;
import br.com.clcode.clcode.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;
	
	public List<OrdemServico> findAll() {
		return repository.findAll();
	}
	
	public OrdemServico findById(Long id) {
		Optional<OrdemServico> obj = repository.findById(id);
		return obj.get();
	}
	
	public OrdemServico insert(OrdemServico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public OrdemServico update(Long id, OrdemServico obj) {
		OrdemServico entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(OrdemServico entity, OrdemServico obj) {
		entity.setDataContratacao(obj.getDataContratacao());
		entity.setPrazoEntrega(obj.getPrazoEntrega());
		entity.setCliente(obj.getCliente());
		entity.setPrestadorServico(obj.getPrestadorServico());
		entity.setServico(obj.getServico());
	}
}
