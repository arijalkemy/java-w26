package org.example.integradorobrasliterarias.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    private String name;
    private String authorName;
    private Integer pages;
    private String editorial;

    private Integer publicationYear;
}
