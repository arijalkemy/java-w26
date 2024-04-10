package org.ggomezr;

public class Participante {
    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private long numeroEmergencia;
    private String grupoSanguineo;

    private static int ultimoParticipante;

    public Participante(int dni, String nombre, String apellido, int edad, long numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = ++ultimoParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
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

    public long getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(long nunmeroEmergencia) {
        this.numeroEmergencia = nunmeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nunmeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
