package Ejercicio.ElasticSearch.Dto;


import lombok.*;

import java.time.LocalDate;

@Data
public class LiteraryWorkRequestDto {
    private String name;

    private String author;

    private String editorial;

    private Integer pages;

    private LocalDate publicationDate;
}
