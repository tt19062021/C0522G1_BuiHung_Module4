package com.example.service.impl;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<BlogDto> findByQuery() {
        return iBlogRepository.findByQuery();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog update(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }


    @Override
    public Page<Blog> findTitleName(String name, Pageable pageable) {
        return iBlogRepository.findTitleName(name, pageable);
    }

    public Page<Blog> findAllBlogOfCategory(int id, Pageable pageable) {
        return iBlogRepository.findAllBlogOfCategory(id, pageable);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> searchById(int id) {
        return iBlogRepository.searchById(id);
    }

    @Override
    public String findContentById(int id) {
        return iBlogRepository.findContentById(id);
    }


}
