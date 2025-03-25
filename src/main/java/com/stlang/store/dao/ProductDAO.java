package com.stlang.store.dao;

import com.stlang.store.domain.Category;
import com.stlang.store.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Category category);
}
