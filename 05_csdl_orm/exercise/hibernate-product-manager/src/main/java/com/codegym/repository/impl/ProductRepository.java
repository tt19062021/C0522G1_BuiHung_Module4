package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;


import static com.codegym.repository.ConnectionUtil.entityManager;

@Repository
public class ProductRepository implements IProductRepository {
//    private static final Map<Integer, Product> productList;
////
//    static {
//
//        productList = new HashMap<>();
//        productList.put(1, new Product(1, "Ronaldo", 100, "Mr. Champion League", "Portugal"));
//        productList.put(2, new Product(2, "Neymar jr", 220, "Samba dancer", "Brazil"));
//        productList.put(3, new Product(3, "De Bruyne", 200, "Leader", "Belgium"));
//        productList.put(4, new Product(4, "Quang Hai", 90, "Hope", "Việt Nam"));
//        productList.put(5, new Product(5, "Harry Maguire", 80, "Destroyer, Burden", "English"));
//    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return productList;

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
    public Product findById(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.id = : id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


    @Override
    public void update(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT p FROM Product AS p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;


        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.name like :name", Product.class);
        query.setParameter("name","%"+ name +"%");
        return query.getResultList();
    }

}
