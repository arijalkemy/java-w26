package com.example.deportista;

import com.example.deportista.entities.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {

    private String nombre;
    private List<Deporte> deportes;
    
}
