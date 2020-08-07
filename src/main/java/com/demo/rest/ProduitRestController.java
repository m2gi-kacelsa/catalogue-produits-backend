package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.ProduitRepository;
import com.demo.entities.Produit;

@RestController
public class ProduitRestController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(value = "/listProduits")
	public List<Produit> listProduits() {
		return produitRepository.findAll();
	}

	@GetMapping(value = "/listProduits/{id}")
	public Produit getProduit(@PathVariable (name = "id") Long id) {
		return produitRepository.findById(id).get();
	}	
	
	@PutMapping(value = "/listProduits/{id}")
	public Produit update(@PathVariable (name = "id") Long id, Produit p) {
		//@RequestBody pour dire que les donnes du produit p vont etre reccupere au format JSON
		p.setId(id);
		return produitRepository.saveAndFlush(p);
	}	
	
	@PostMapping(value = "/listProduits")
	public Produit addProduit(@RequestBody Produit p) {
		//@RequestBody pour dire que les donnes du produit p vont etre reccupere au format JSON
		return produitRepository.saveAndFlush(p);
	}
	
	@DeleteMapping(value = "/listProduits/{id}")
	public void remove(@PathVariable (name = "id") Long id) {
		//@RequestBody pour dire que les donnes du produit p vont etre reccupere au format JSON
	     produitRepository.deleteById(id);;
	}
}
