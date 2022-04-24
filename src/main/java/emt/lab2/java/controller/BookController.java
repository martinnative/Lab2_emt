package emt.lab2.java.controller;

import emt.lab2.java.model.Book;
import emt.lab2.java.model.dto.BookDto;
import emt.lab2.java.model.enumeration.BookCategory;
import emt.lab2.java.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static emt.lab2.java.model.enumeration.BookCategory.allCategories;

@CrossOrigin
@RestController
@RequestMapping ("/rest/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody BookDto dto){
        return bookService.add(dto);
    }

    @PostMapping("/edit/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookDto dto){
        return bookService.edit(id, dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @PostMapping("/take/{id}")
    public void takeBook(@PathVariable Long id){
        bookService.takeBook(id);
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @GetMapping("/categories")
    public List<BookCategory> categories(){
        return allCategories();
    }

    @GetMapping("/all/page/{page}/{size}")
    public List<Book> findAllWithPagination(@PathVariable Integer size, @PathVariable Integer page) {
        return bookService.findAllWithPagination(page,size).getContent();
    }
}
