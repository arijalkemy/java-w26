package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookResponse {
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private Date publishedDate;
}
