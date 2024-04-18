package com.bootcampjava.blogapirest.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradBlogDTO {
    private String titulo;
    private String fechaSubida;
    private String nombreAutor;
}
