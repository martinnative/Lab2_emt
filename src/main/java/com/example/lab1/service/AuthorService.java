package com.example.lab1.service;

import com.example.lab1.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author saveAuthor(Author author);
}
