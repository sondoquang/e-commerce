package com.stlang.store.service;

import com.stlang.store.dto.ProductDTO;
import com.stlang.store.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findAll(Integer category);
    Product findById(Integer id);
    Product create(Product product);
    Product update(Product product);
    void delete(Integer id);
    ProductDTO convertToDTO(Product product);
    List<ProductDTO> getConvertProductDTOs(List<Product> products);
}
