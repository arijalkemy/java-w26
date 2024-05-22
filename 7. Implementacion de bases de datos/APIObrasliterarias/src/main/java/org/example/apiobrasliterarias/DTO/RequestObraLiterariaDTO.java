package org.example.apiobrasliterarias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestObraLiterariaDTO {
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
