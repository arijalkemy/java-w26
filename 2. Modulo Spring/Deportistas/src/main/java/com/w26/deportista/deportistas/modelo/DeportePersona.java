package com.w26.deportista.deportistas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DeportePersona {
    private Persona persona;
    private Deporte deporte;

}
