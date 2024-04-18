package com.bootcamp.blog.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EntradaBlogDto implements Serializable {
    private int id;
    private String titulo;
    private String nombreAutor;
    private Date fechaDePublicacion;
}
