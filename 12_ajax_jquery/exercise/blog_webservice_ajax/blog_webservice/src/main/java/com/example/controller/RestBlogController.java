package com.example.controller;

import com.example.dto.BlogDto;
import com.example.dto.RestBlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blog/v1")
@CrossOrigin("*")
public class RestBlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogList = iBlogService.findAll();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findBlogOfCategory(@PathVariable int id) {
        List<Blog> blogList = iBlogService.searchById(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<String> findBlogById(@PathVariable int id) {
        String blog = iBlogService.findContentById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogByTitle(@RequestParam(defaultValue = "") String name){
        List<Blog> blogList = iBlogService.searchByTitle(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }

    }
}
