package emt.lab2.java.Service;

import emt.lab2.java.Model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author saveAuthor(Author author);
}
