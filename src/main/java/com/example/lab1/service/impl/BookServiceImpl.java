package com.example.lab1.service.impl;

import com.example.lab1.model.Author;
import com.example.lab1.model.Book;
import com.example.lab1.model.dto.BookDto;
import com.example.lab1.model.enumeration.BookCategory;
import com.example.lab1.model.exception.AuthorNotFoundException;
import com.example.lab1.model.exception.BookNotFoundException;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.BookRepository;
import com.example.lab1.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.delete(book);
    }

    @Override
    public Book add(BookDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(AuthorNotFoundException::new);
        Book book = new Book(dto.getName(), dto.getCategory(), author, dto.getCopies());
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book edit(Long id, BookDto dto) {
        Book book = this.getBook(id);
        book.setName(dto.getName());
        book.setCategory(BookCategory.valueOf(dto.getCategory()));
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(AuthorNotFoundException::new);
        book.setAuthor(author);
        book.setAvailableCopies(dto.getCopies());
        bookRepository.save(book);
        return book;
    }

    @Override
    public void takeBook(Long id) {
        Book book = this.getBook(id);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Page<Book> findAllWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

}
