package com.stlang.store.service;

import com.stlang.store.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Integer id);
    Category findByName(String name);
    Category create(Category category);
    Category update(String name, Integer id);
    void delete(Integer id);

}
