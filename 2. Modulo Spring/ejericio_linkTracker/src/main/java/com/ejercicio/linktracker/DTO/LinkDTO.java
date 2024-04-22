package com.ejercicio.linktracker.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LinkDTO {
    private int id;
    private String url;
    private int visitsNumber;
}
