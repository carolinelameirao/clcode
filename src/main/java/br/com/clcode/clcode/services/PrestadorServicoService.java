package br.com.clcode.clcode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clcode.clcode.model.entities.PrestadorServico;
import br.com.clcode.clcode.repositories.PrestadorServicoRepository;

@Service
public class PrestadorServicoService {

	@Autowired
	private PrestadorServicoRepository repository;
	
	public List<PrestadorServico> findAll() {
		return repository.findAll();
	}
	
	public PrestadorServico findById(Long id) {
		Optional<PrestadorServico> obj = repository.findById(id);
		return obj.get();
	}
	
	public PrestadorServico insert(PrestadorServico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public PrestadorServico update(Long id, PrestadorServico obj) {
		PrestadorServico entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(PrestadorServico entity, PrestadorServico obj) {
		entity.setNome(obj.getNome());
		entity.setFuncao(obj.getFuncao());
		entity.setCpf(obj.getCpf());
		entity.setTelefone(obj.getTelefone());
		entity.setEmail(obj.getEmail());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setEndereco(obj.getEndereco());
	}
}
