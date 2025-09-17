package com.nie.csd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Products getByProductId(String id) throws IdNotPresentException {
        return repository.findById(id)
        .orElseThrow( () -> new IdNotPresentException("Product not found id: "+id)) ;
    }

    public Products addProducts(Products products) {
        return repository.save(products);
    }

    public Products updateProducts(String id, Products product) {
        Products existingProduct = repository.findById(id).get();
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setTags(product.getTags());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            return repository.save(existingProduct);
        }
        return repository.save(product);
        // if the product exists, update it; otherwise, add a new product
        // the id is not being updated here
    }

    public void deleteProducts(String id) {
        Products existingProduct = repository.findById(id).get();
        if (existingProduct != null){
            repository.deleteById(id);
            System.out.println("Product deleted succesfully");
        }
        else{
            System.out.println("Product with id " + id + " not found");
        } 
    }
}
