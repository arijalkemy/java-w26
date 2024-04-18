package com.ejercicio.manejodeblogs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BlogEntry {
    private int id;
    private String title;
    private String authorName;
    private String date;
}
