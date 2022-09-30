package com.example.service;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<BlogDto> findByQuery();

    void save(Blog blog);

    Blog findById(int id);

    Blog update(Blog blog);

    void remove(int id);

    Page<Blog> findTitleName(String name, Pageable pageable);

    Page<Blog> findAllBlogOfCategory(int id, Pageable pageable);

    List<Blog> findAll();

    List<Blog> searchById(int id);

    String findContentById(int id);
}
