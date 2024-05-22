package jpa.ejercicioelasticsearch.dto.requestDTO;

import lombok.Data;

@Data
public class ObraLiterariaRequestDto {

    private String name;

    private String author;

    private Integer numberPages;

    private String editorial;

    private Integer yearPublication;
}
