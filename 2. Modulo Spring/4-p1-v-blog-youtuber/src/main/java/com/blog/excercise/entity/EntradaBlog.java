package com.blog.excercise.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public EntradaBlog() {
    }
}
