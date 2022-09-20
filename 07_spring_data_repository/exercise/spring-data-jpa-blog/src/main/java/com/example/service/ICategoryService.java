package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findByAll();

    void save(Category category);

    Category findById(int id);

    Category update(Category category);

    void remove(int id);

}
