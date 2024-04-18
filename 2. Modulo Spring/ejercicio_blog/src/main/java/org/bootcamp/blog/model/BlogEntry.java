package org.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntry {

    private int id;
    private String title;
    private String author;
    private Date date;

}
