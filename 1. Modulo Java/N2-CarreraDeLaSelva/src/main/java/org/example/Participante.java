package org.example;

public class Participante {
    private int id;
    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long celular;
    private long celularDeEmergencia;
    private String grupoSanguineo;

    public Participante(int id, long dni, String nombre, String apellido, int edad, long celular, long celularDeEmergencia, String grupoSanguineo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celularDeEmergencia = celularDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public long getCelularDeEmergencia() {
        return celularDeEmergencia;
    }

    public void setCelularDeEmergencia(int celularDeEmergencia) {
        this.celularDeEmergencia = celularDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
