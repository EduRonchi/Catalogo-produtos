package com.catalogo.produtos.repositories.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.catalogo.produtos.entities.Product;
import com.catalogo.produtos.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(1L, "Shampoo", "Shampoo para cabelos oleosos.", 28.99);
		Product p2 = new Product(2L, "Condicionador", "Hidratação intensa e fios mais fortes.", 18.50);
		Product p3 = new Product(3L, "Sabonete", "Sabonete que ajuda na hidratação da pele.", 5.25);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

	
}
