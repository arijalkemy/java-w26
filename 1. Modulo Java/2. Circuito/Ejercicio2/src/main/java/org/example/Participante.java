package org.example;

public class Participante {

    private int nroParticipante;
    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;

    public Participante(int nroParticipante, long dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.nroParticipante = nroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(int nroParticipante) {
        this.nroParticipante = nroParticipante;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    private String grupoSanguineo;

    @Override
    public String toString() {
        return
                "nroParticipante=" + nroParticipante +
                "\n dni=" + dni +
                "\n nombre='" + nombre +
                "\n apellido='" + apellido +
                "\n edad=" + edad +
                "\n celular='" + celular +
                "\n numeroEmergencia='" + numeroEmergencia +
                "\n grupoSanguineo='" + grupoSanguineo;
    }
}
