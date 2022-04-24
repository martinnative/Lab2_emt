package emt.lab2.java.Model;


import emt.lab2.java.Model.Enumerations.BookCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(String name, String category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = BookCategory.valueOf(category);
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }
}
