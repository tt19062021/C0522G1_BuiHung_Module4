package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductReponsitory implements IProductReponsitory {


    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1, "Hùng Hồ Hiểu", 3000, "Viet Nam", "just"));
        productList.put(2,new Product(2, "Apple", 2000, "Viet Nam", "just"));
        productList.put(3,new Product(3, "ApplePen", 5000, "Viet Nam", "just"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public String view(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }


    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> search(String name) {
       List<Product> proList = new ArrayList<>();

        for(Product item: productList.values()){
            if(item.getProductName().contains(name)){
                proList.add(item);
            }
        }
        return proList;
    }
}

