package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;

public interface ProductService {
    Iterable<Product> findAll();
    void save(Product product);
    void remove(Long id);
    Product findById(Long id);

}
