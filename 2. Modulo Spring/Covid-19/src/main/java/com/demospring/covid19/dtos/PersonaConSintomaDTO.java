package com.demospring.covid19.dtos;

public class PersonaConSintomaDTO {
    private String nombre;
    private String apellido;
    private String nombreSintoma;

    public PersonaConSintomaDTO(String nombre, String apellido, String nombreSintoma) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreSintoma = nombreSintoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreSintoma() {
        return nombreSintoma;
    }

    public void setNombreSintoma(String nombreSintoma) {
        this.nombreSintoma = nombreSintoma;
    }
}
