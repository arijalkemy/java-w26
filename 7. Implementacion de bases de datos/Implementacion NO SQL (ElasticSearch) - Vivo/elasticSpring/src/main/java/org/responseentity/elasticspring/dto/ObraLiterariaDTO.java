package org.responseentity.elasticspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObraLiterariaDTO {
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimerPublicacion;
}
