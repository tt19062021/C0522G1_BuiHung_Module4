package com.example.repository;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    //    @Query(value = "select * from Blog where name like %:keyword%", nativeQuery = true)
//    List<Blog> searchByName(@Param("keyword") String name);
//    List<Blog> findAllById(int id,Pageable pageable);
}
