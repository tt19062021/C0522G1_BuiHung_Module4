package com.example.repository;


import com.example.dto.BlogDto;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select * from blog where title like %:keysearch%", nativeQuery = true)
    Page<Blog> findTitleName(@Param("keysearch") String name, Pageable pageable);

    @Query(value = "select * from blog where category_id = :keyword", nativeQuery = true)
    Page<Blog> findAllBlogOfCategory(@Param("keyword") int id, Pageable pageable);

    @Query(value = "select b.title as titleDto, c.category_name as cateDto from blog b join category c on b.category_id = c.id",nativeQuery = true)
    List<BlogDto> findByQuery();

    @Query(value = "select * from blog where category_id = :keyword", nativeQuery = true)
    List<Blog> searchById(@Param("keyword") int id);

    @Query(value = "select blog.content from blog where id =:keyword",nativeQuery = true)
    String findContentById(@Param("keyword") int id);
}
