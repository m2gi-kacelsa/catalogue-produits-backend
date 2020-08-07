package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.demo.dao.ProduitRepository;
import com.demo.entities.Produit;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null, "acer2", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer3", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer4", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer5", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer6", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer7", 4800.00, 5));
		produitRepository.save(new Produit(null, "acer8", 4800.00, 5));
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.toString()); 
		});
	}

}
