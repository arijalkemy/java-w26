package jpa.ejercicioelasticsearch.dto.reponseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObraliterariaResponseDto {

    private String id;

    private String name;

    private String author;

    private Integer numberPages;

    private String editorial;

    private Integer yearPublication;
}
