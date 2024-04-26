package org.example.covid.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class PersonaSintomaDTO implements Serializable {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> nombreSintoma;

    public PersonaSintomaDTO(String id, String nombre, String apellido, int edad, List<String> nombreSintoma) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombreSintoma = nombreSintoma;
    }

}
