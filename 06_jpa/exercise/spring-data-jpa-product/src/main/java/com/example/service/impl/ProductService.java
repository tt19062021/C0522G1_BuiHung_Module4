package com.example.service.impl;


import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
       return productRepository.findById(id);
    }


    @Override
    public Product update(Product product) {
       return productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

}
