package com.sinc_ejercicioblog.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class EntradaBlog {
    private int idBlog;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
