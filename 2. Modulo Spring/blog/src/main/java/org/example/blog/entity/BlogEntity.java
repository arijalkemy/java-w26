package org.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntity {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
