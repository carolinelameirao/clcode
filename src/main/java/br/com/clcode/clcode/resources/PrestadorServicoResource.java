package br.com.clcode.clcode.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.clcode.clcode.model.entities.PrestadorServico;
import br.com.clcode.clcode.services.PrestadorServicoService;

@RestController
@RequestMapping(value = "/prestadorServicos")
public class PrestadorServicoResource {

	@Autowired
	private PrestadorServicoService service;
	
	@GetMapping
	public ResponseEntity<List<PrestadorServico>> findAll() {
		List<PrestadorServico> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PrestadorServico> findById(@PathVariable Long id) {
		PrestadorServico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<PrestadorServico> insert(@RequestBody PrestadorServico obj) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PrestadorServico> update(@PathVariable Long id, @RequestBody PrestadorServico obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
