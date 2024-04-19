package com.example.ejercicioBlog.model;

import lombok.Data;

@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
