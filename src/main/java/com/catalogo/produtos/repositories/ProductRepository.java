package com.catalogo.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.produtos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
