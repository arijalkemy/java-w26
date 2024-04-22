package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogDTO {
    private Integer id;
    private String title;
    private String author;
    private String date;
}
