package com.w26.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class Blog {
    private int id;
    private String title;
    private String authorName;
    private LocalDate publishDate;
}
