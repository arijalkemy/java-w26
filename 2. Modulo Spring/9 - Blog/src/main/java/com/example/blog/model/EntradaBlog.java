package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class EntradaBlog {
    private String id;
    private String title;
    private String author;
    private LocalDate date;
}
