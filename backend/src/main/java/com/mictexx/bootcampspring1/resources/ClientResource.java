package com.mictexx.bootcampspring1.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mictexx.bootcampspring1.entities.Client;
import com.mictexx.bootcampspring1.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	//@GetMapping
	//public ResponseEntity<List<Client>> findAll(){
		////User u = new User(1L,"Maria", "maria@gmail.com", "999999999", "12345" );
	//	List<Client> list = service.findAll();
	//	return ResponseEntity.ok().body(list);
	//}
	
	
	@GetMapping
	public ResponseEntity<Page<Client>> findAll(
			
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy			
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<Client> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);		
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client cl){
		cl = service.insert(cl);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cl.getId()).toUri();
		return ResponseEntity.created(uri).body(cl);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client cl){
		cl = service.update(id, cl);
		return ResponseEntity.ok().body(cl);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
