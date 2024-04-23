package com.youtuber_rest.youtuber_rest.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BlogModel {
    private Long id;
    private String title; 
    private String author;
    private LocalDate publishDate;  
}
