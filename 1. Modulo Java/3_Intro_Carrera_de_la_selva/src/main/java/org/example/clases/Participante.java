package org.example.clases;

public class Participante {

    private static int ultimoNumeroParticipante = 1;

    private final int numeroParticipante;
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String telefono;
    private final String grupoSanguineo;


    public Participante(String dni, String nombre, String apellido, int edad, String telefono, String grupoSanguineo) {
        this.numeroParticipante = ultimoNumeroParticipante++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.grupoSanguineo = grupoSanguineo;
    }


    public static int getUltimoNumeroParticipante() {
        return ultimoNumeroParticipante;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
