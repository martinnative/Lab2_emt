package com.example.lab1.dataHolder;

import com.example.lab1.model.Author;
import com.example.lab1.model.Book;
import com.example.lab1.model.Country;
import com.example.lab1.repository.AuthorRepository;
import com.example.lab1.repository.BookRepository;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.service.AuthorService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();
    public final BookRepository bookRepository;
    public final CountryRepository countryRepository;
    public final AuthorRepository authorRepository;
    public final AuthorService authorService;

    public DataHolder(BookRepository bookRepository, CountryRepository countryRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country("Makedonija", "evropa");
        Country country2 = new Country("Srbija", "evropa");
        Country country3 = new Country("Germanija", "evropa");
        Country country4 = new Country("Brazil", "amerika");
        Author author1 = new Author("Ime1", "Prezime1", country1);
        Author author2 = new Author("Ime2", "Prezime2", country2);
        Author author3 = new Author("Ime3", "Prezime3", country3);
        Author author4 = new Author("Ime4", "Prezime4", country4);

        Book book1 = new Book("Kniga1", "FANTASY", author1, 10);
        Book book2 = new Book("Kniga2", "BIOGRAPHY", author2, 5);
        Book book3 = new Book("Kniga3", "CLASSICS", author3, 10);
        Book book4 = new Book("Kniga4", "FANTASY", author4, 20);
        Book book5 = new Book("Kniga5", "CLASSICS", author3, 50);
        Book book6 = new Book("Kniga6", "CLASSICS", author4, 100);
        Book book7 = new Book("Kniga7", "FANTASY", author4, 200);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);

        countryRepository.saveAll(countries);
        authorRepository.saveAll(authors);
        bookRepository.saveAll(books);

    }

}
