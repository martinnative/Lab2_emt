package emt.lab2.java.service;

import emt.lab2.java.model.Book;
import emt.lab2.java.model.dto.BookDto;
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
