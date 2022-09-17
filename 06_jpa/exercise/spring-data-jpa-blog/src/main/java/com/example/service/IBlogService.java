package com.example.service;
import com.example.model.Blog;
import java.util.List;

public interface IBlogService {

    List<Blog> findByAll();

    void save(Blog blog);

    Blog findById(int id);

    Blog update(Blog blog);

    void remove(int id);
//    List<Blog> searchByName(String name);
}
