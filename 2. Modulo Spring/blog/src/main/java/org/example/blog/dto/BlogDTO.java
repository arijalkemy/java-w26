package org.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
