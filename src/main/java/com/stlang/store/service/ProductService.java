package com.stlang.store.service;

import com.stlang.store.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findAll(Integer category);
    Product findById(Integer id);
    Product create(Product product);
    Product update(Product product);
    void delete(Integer id);
}
