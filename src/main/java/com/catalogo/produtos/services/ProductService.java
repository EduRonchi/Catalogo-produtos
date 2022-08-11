package com.catalogo.produtos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.catalogo.produtos.entities.Product;
import com.catalogo.produtos.repositories.ProductRepository;
import com.catalogo.produtos.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;	
			
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);		
	} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
	}
	}
	
	public Product update(Long id, Product obj) {
		Product entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Product entity, Product obj) {
	entity.setName(obj.getName());
	entity.setDescription(obj.getDescription());
	entity.setPrice(obj.getPrice());
	}
}
