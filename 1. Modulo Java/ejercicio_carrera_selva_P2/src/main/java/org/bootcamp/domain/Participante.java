package org.bootcamp.domain;

public class Participante {

    private static int contadorId = 1;

    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;


    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Participante.contadorId = contadorId;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public String toString() {
        StringBuffer sb = new StringBuffer("\nnúmero de participante: ").append(numeroParticipante);
        sb.append("\nDNI: ").append(dni);
        sb.append("\nnombre: ").append(nombre);
        sb.append("\napellido: ").append(apellido);
        sb.append("\nedad: ").append(edad);
        sb.append("\ncelular: ").append(celular);
        sb.append("\nnumero de emergencia: ").append(numeroEmergencia);
        sb.append("\ngrupo sanguíneo: ").append(grupoSanguineo);
        return sb.toString();
    }
}
