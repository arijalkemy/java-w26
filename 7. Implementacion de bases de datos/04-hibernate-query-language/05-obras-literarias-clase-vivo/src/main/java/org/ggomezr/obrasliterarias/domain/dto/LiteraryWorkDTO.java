package org.ggomezr.obrasliterarias.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteraryWorkDTO {
    private String id;
    private String title;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer releaseDateYear;
}
