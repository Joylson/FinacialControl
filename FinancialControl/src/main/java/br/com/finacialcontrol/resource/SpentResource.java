package br.com.finacialcontrol.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.finacialcontrol.DTO.SpentDTO;
import br.com.finacialcontrol.entity.Spent;
import br.com.finacialcontrol.service.SpentService;

@RestController
@RequestMapping("api/spent")
public class SpentResource {

	@Autowired
	private SpentService service;
	
	@GetMapping
	public ResponseEntity<List<Spent>> get() {
		List<Spent> spents = service.findAll();
		return ResponseEntity.ok(spents);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Spent> get(@PathVariable("id") long id){
		Spent spent = service.findById(id);
		return ResponseEntity.ok(spent);
	}
	
	@PostMapping
	public ResponseEntity<Spent> post(@Valid @RequestBody SpentDTO dto){
		Spent entity = dto.toEntity();
		entity = service.save(entity);
		return ResponseEntity.ok(entity);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Spent> put(@PathVariable("id") long id, @Valid @RequestBody SpentDTO dto){
		Spent entity = dto.toEntity();
		entity.setId(id);
		entity = service.update(entity);
		return ResponseEntity.ok(entity);
	}
}
