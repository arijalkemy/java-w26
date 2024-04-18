package com.bootcamp.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EntradaBlog {

    private int id;
    private String titulo;
    private String nombreAutor;
    private Date fechaDeCreacion;
}
