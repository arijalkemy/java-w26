package org.miprimerproyecto.deportistasvivo.DTO;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private DeporteDTO deporte;

    public PersonaDTO() {}

    public PersonaDTO(long id, String nombre, String apellido, int edad, DeporteDTO deporte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public String getDeporte() {
        return deporte.toString();
    }

    public void setDeporte(DeporteDTO deporte) {
        this.deporte = deporte;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
