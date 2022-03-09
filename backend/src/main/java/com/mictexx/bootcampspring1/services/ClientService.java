package com.mictexx.bootcampspring1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mictexx.bootcampspring1.entities.Client;
import com.mictexx.bootcampspring1.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Client> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);

		return list.map(x -> new Client(x));
	}

	@Transactional(readOnly = true)
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.get();
		return entity;
		// Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity
		// not found"));
		// return new ProductDTO(entity, entity.getCategories());

	}

	@Transactional
	public Client insert(Client cl) {
		Client entity = new Client();
		entity.setName(cl.getName());
		entity.setCpf(cl.getCpf());
		entity.setIncome(cl.getIncome());
		entity.setBirthDate(cl.getBirthDate());
		entity.setChildren(cl.getChildren());
		repository.save(entity);
		return entity;
	}

	@Transactional
	public Client update(Long id, Client cl) {
		try {
			Client entity = repository.getOne(id);
			entity.setName(cl.getName());
			entity.setCpf(cl.getCpf());
			entity.setIncome(cl.getIncome());
			entity.setBirthDate(cl.getBirthDate());
			entity.setChildren(cl.getChildren());
			entity = repository.save(entity);
			return entity;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch (RuntimeException e){
			throw new RuntimeException("Id not found "+ id);
		}
		
	}

}
