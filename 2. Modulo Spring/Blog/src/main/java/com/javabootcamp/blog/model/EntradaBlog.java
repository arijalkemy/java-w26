package com.javabootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlog {
    int id;
    String title;
    String authorName;
    String publishedDate;
}
