package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService  {
    @Autowired
    public ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product.getId());
    }
    @Override
    public Product findById(Long id){
        return productRepository.findOne(id);
    }


}
