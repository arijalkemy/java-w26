package org.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogEntity {
    private int id;
    private String title;
    private String author;
    private String date;
}
