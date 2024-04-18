package org.example.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.example.blog.model.EntradaBlog;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class BlogRequestDTO implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;

    public BlogRequestDTO() {}
}
