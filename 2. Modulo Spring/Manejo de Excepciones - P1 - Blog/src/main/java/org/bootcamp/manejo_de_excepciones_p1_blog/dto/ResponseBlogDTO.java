package org.bootcamp.manejo_de_excepciones_p1_blog.dto;

import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;

import java.util.Map;

public class ResponseBlogDTO {
    private Integer id;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
