package com.mictexx.bootcampspring1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mictexx.bootcampspring1.entities.Client;
import com.mictexx.bootcampspring1.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		//User u = new User(1L,"Maria", "maria@gmail.com", "999999999", "12345" );
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

}
