package com.blog.excercise.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class BlogDTO implements Serializable {

    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public BlogDTO() {
    }
}
