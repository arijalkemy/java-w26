package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDTO {
    private String id;
    private String name;
    private String author;
    private int pageCount;
    private String publisher;
    private Year publicationYear;
}
