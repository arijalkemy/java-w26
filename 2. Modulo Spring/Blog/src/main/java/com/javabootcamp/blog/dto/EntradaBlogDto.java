package com.javabootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogDto {
    String title;
    String authorName;
    String publishedDate;
}
