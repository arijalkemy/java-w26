package org.example.Clases;

public class Participante {
    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    
    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, String celular,
            String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public Participante() {
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
    public String getGrupoSanguíneo() {
        return grupoSanguineo;
    }
    public void setGrupoSanguíneo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString(){
        return  "  Participante:" + "\n" +
                "    Número participante:" + numeroParticipante + "\n" +
                "    DNI:" + dni + "\n" +
                "    Nombre: " + nombre + "\n" +
                "    Apellido: " + apellido + "\n" +
                "    Edad: " + edad + "\n" +
                "    Celular: " + celular + "\n" +
                "    Número de emergencia: " + numeroEmergencia + "\n" +
                "    Grupo sanguineo: " + grupoSanguineo + "\n" ;
    }

}
