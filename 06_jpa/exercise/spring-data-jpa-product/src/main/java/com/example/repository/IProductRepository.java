package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    //    @Query(value = "select * from Product where id = :keyword",nativeQuery = true)
    @Query(value = "select * from Product where name like %:keyword%", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String name);

    Product findById(int id);
}
