package com.bootcamp.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
