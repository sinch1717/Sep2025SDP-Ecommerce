package com.nie.csd.services;

import java.util.List;
// import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.apache.commons.logging.LogFactory; // Removed unused import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.*;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    public List<Products> getAllProducts() {
        logger.info("Retrieving all products from the database of collections products");
        return repository.findAll();
    }

    public Products getByProductId(String id) throws IdNotPresentException {
        logger.debug("Retrieving product with id : {} from database "+"of collections products", id);
        return repository.findById(id)
        .orElseThrow( () -> {
            logger.error("Product with id: "+id+" not found in the database of collections products");
            logger.info("Error logged");
            return new IdNotPresentException("Product not found id: "+id);
         }
        );
    }

    public Products addProducts(Products products) {
        logger.info("Adding new product to the database of collection products");
        return repository.save(products);
    }

    public Products updateProducts(String id, Products product) {
    Products existingProduct = repository.findById(id).orElse(null);

    if (existingProduct != null) {
        logger.info("Product with id {} updated in collection products", id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setTags(product.getTags());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        return repository.save(existingProduct);
    } else {
        logger.info("Product with id {} not found, saving as new product", id);
        product.setId(id); // important if you want to save with the same id
        return repository.save(product);
        }
    }


    public void deleteProducts(String id) {
        Products existingProduct = repository.findById(id).get();
        if (existingProduct != null){
            logger.info("Product with id "+id+"deleted successfully from collection products");
            repository.deleteById(id);
            System.out.println("Product deleted succesfully");
        }
        else{
            logger.info("Product with id "+id+"not found");
            System.out.println("Product with id " + id + " not found");
        } 
    }
}
