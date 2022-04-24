package com.example.lab1.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;
    private Long authorId;
    private String category;
    private Integer copies;
}
