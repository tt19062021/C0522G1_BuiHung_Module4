package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductReponsitory;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductReponsitory iProductReponsitory ;

    @Override
    public List<Product> findAll() {
        return iProductReponsitory.findAll();
    }


    @Override
    public Product findById(int id) {
        return iProductReponsitory.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductReponsitory.save(product);
    }

    @Override
    public void delete(int id) {
        iProductReponsitory.delete(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductReponsitory.update(id,product);
    }

    @Override
    public List<Product> search(String name) {
        return iProductReponsitory.search(name);
    }

}
