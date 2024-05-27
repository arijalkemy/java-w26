package org.example;

import java.util.Objects;

public class Participante {
    public Participante(Integer numero, String dni, String nombre, String apellido, Integer edad, Integer celular, Integer numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(numero, that.numero) && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(edad, that.edad) && Objects.equals(celular, that.celular) && Objects.equals(numeroEmergencia, that.numeroEmergencia) && Objects.equals(grupoSanguineo, that.grupoSanguineo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, dni, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(Integer numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer celular;
    private Integer numeroEmergencia;
    private String grupoSanguineo;
}
