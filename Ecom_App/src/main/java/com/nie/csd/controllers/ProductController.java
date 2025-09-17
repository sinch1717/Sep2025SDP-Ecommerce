package com.nie.csd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;


    
    // Return a list of products
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> productList = service.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    // get a product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getByProductId(@PathVariable("id") String id) throws IdNotPresentException{
	    Products product = service.getByProductId(id);
        return ResponseEntity.ok(product);
     //.orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    // add a new product
    @PostMapping("/products")
    public Products addProducts(@RequestBody Products product) {
        return service.addProducts(product);
    }

    // update a product by id; else add a new product
    @PutMapping("/products/{id}")
    public Products updateProducts(@PathVariable("id") String id, @RequestBody Products product) {
        // Implementation for updating a product
        return service.updateProducts(id, product); // Placeholder return statement
    }

    // delete a product by id
    @DeleteMapping("/products/{id}")
    public void deleteProducts(@PathVariable("id") String id) {
        service.deleteProducts(id); 
    }
}