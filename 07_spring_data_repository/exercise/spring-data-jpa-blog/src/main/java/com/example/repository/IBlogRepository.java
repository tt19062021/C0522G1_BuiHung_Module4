package com.example.repository;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);

    @Query(value = "select * from blog where category_id = :keyword",nativeQuery = true)
    Page<Blog> findAllViewBlog(@Param("keyword") int id,Pageable pageable);
}
