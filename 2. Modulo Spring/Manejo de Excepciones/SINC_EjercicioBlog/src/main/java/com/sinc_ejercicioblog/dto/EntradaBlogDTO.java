package com.sinc_ejercicioblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class EntradaBlogDTO {
    private int idBlog;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
