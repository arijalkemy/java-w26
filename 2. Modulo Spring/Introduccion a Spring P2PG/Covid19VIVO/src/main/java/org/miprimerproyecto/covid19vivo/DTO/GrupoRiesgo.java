package org.miprimerproyecto.covid19vivo.DTO;

import org.miprimerproyecto.covid19vivo.clases.Sintoma;

import java.io.Serializable;
import java.util.List;

public class GrupoRiesgo implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomaList;

    public GrupoRiesgo(int id, String nombre, String apellido, int edad, List<Sintoma> sintomaList) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomaList = sintomaList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Sintoma> getSintomaList() {
        return sintomaList;
    }

    public void setSintomaList(List<Sintoma> sintomaList) {
        this.sintomaList = sintomaList;
    }


}
