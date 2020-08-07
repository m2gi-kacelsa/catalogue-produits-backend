package com.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p", types = Produit.class)
public interface ProduitProjection {

	public double getPrice();
	
	public String getDesignation();
	
}
