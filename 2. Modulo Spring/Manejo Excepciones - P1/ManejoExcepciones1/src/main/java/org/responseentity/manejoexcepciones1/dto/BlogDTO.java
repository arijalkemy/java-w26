package org.responseentity.manejoexcepciones1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private String titulo;
    private String autor;
    private LocalDateTime fechaPublicacion;
}
