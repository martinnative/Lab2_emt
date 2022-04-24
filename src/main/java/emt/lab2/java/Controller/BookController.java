package emt.lab2.java.Controller;

import emt.lab2.java.Model.Book;
import emt.lab2.java.Model.data_transfer.BookDto;
import emt.lab2.java.Model.Enumerations.BookCategory;
import emt.lab2.java.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static emt.lab2.java.Model.Enumerations.BookCategory.allCategories;

@CrossOrigin
@RestController
@RequestMapping ("/rest/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/all/page/{page}/{size}")
    public List<Book> findAllWithPagination(@PathVariable Integer size, @PathVariable Integer page) {
        return bookService.findAllWithPagination(page,size).getContent();
    }

    @GetMapping("/all")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/edit/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookDto dto){
        return bookService.edit(id, dto);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody BookDto dto){
        return bookService.add(dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }
    @PostMapping("/take/{id}")
    public void takeBook(@PathVariable Long id){
        bookService.takeBook(id);
    }

    @GetMapping("/categories")
    public List<BookCategory> categories(){
        return allCategories();
    }


}
