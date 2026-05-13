package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.Entity.Product;
import com.wms.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProuctContoller {

	@Autowired
	ProductService service;
	
	 @PostMapping
	 public Product saveProduct(@Valid @RequestBody Product product) {
	        return service.saveProduct(product);
	    }

	  @GetMapping
      public List<Product> getAllProducts() {
	        return service.getAllProducts();
	    }

	  @GetMapping("/{id}")
	  public Product getProduct(@PathVariable Long id) {
	        return service.getProductById(id);
	    }

	  @DeleteMapping("/{id}")
	  public String deleteProduct(@PathVariable Long id) {
	        service.deleteProduct(id);
	        return "Product Deleted Successfully";
	    }
	
}
