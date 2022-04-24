package com.example.lab1.service;

import com.example.lab1.model.Book;
import com.example.lab1.model.dto.BookDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void delete(Long id);
    Book add(BookDto dto);
    Book edit(Long id, BookDto dto);
    void takeBook(Long id);
    Book getBook(Long id);
    Page<Book> findAllWithPagination(int page, int size);
}
