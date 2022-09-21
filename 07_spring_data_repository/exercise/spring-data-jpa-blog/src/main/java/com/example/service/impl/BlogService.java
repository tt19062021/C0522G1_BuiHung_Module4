package com.example.service.impl;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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

    public Page<Blog> findAllViewBlog(int id, Pageable pageable) {
        return iBlogRepository.findAllViewBlog(id, pageable);
    }


}
