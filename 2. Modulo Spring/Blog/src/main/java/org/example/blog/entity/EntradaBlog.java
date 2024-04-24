package org.example.blog.entity;

import lombok.Data;

@Data
public class EntradaBlog {
    private int id;
    private static int nextId = 1;
    private String postName;
    private String authorName;
    private String publishedDate;


    public EntradaBlog(String postName, String authorName, String publishedDate) {
        id = nextId++;
        this.postName = postName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
    }
}
