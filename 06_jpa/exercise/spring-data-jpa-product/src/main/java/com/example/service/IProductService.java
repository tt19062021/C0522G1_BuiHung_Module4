package com.example.service;


import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    Product update(Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}
