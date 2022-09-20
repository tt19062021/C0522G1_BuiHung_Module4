package com.example.service;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findByAll();

    void save(Blog blog);

    Blog findById(int id);

    Blog update(Blog blog);

    void remove(int id);



   Page<Blog> findAllByTitle(String name,Pageable pageable);

    Page<Blog> findAllViewBlog(int id,Pageable pageable);
}
