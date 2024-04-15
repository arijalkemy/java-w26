package org.example;

public class Competidor {
    private int numeroParticipante;
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;
    private boolean inscripto;

    public Competidor(int numeroParticipante, String nombre, String apellido, String dni, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.inscripto = false;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getNumeroDeEmergencia() {
        return numeroDeEmergencia;
    }

    public void setNumeroDeEmergencia(String numeroDeEmergencia) {
        this.numeroDeEmergencia = numeroDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public boolean estaInscripto() {
        return this.inscripto;
    }

    public void inscribir() {
        this.inscripto = true;
    }

    public void desinscribir() {
        this.inscripto = false;
    }

}
