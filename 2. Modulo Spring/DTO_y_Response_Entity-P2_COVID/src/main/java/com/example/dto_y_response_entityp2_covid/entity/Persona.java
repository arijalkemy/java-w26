package com.example.dto_y_response_entityp2_covid.entity;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

    private Integer codigoSintoma;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellido, Integer edad, Integer codigoSintoma) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.codigoSintoma = codigoSintoma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCodigoSintoma() {
        return codigoSintoma;
    }

    public void setCodigoSintoma(Integer codigoSintoma) {
        this.codigoSintoma = codigoSintoma;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
