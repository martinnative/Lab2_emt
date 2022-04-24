package emt.lab2.java.Model.data_transfer;

import lombok.Data;

@Data
public class BookDto {

    private String name;
    private Long authorId;
    private String category;
    private Integer copies;
}
