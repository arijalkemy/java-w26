package com.mercadolibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogEntry {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDateTime publishDate;
}
