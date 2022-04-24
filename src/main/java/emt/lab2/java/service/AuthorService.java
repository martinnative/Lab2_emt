package emt.lab2.java.service;

import emt.lab2.java.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author saveAuthor(Author author);
}
