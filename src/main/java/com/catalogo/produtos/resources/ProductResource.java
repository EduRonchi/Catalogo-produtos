package com.catalogo.produtos.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.produtos.entities.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@GetMapping
	public ResponseEntity<Product> findAll() {
		Product p = new Product(1L, "Shampoo", "Shampoo para cabelos oleosos.", 18.90);
		return ResponseEntity.ok().body(p);
	}
}
