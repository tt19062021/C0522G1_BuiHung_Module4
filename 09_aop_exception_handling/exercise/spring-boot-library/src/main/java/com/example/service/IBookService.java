package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);

    Book findById(int id);

    void update(Book book);

}
