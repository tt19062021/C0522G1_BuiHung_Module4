package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {

//    private static Map<Integer, Product> productList;
//
//    static {
//        productList = new HashMap<>();
//        productList.put(1,new Product(1, "Hùng Hồ Hiểu", 3000, "Viet Nam", "just"));
//        productList.put(2,new Product(2, "Apple", 2000, "Viet Nam", "just"));
//        productList.put(3,new Product(3, "ApplePen", 5000, "Viet Nam", "just"));
//
//    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product>  productList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return productList;
//        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
//        productList.remove(id);
    }

    @Override
    public String view(int id) {
        return null;
    }

    @Override
    public void update(Product product) {
//        productList.put(product);
    }


    @Override
    public Product findById(int id) {
//        return productList.get(id);
        return null;
    }

    @Override
    public List<Product> search(String name) {
//       List<Product> proList = new ArrayList<>();
//
//        for(Product item: productList.values()){
//            if(item.getProductName().contains(name)){
//                proList.add(item);
//            }
//        }
//        return proList;
        return null;
    }
}

