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
//    List<Blog> searchByName(String name);
//List<Blog> findAllById(int id,Pageable pageable);
}
