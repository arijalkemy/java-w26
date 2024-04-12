package org.example;

public class Participante {
    Integer numeroParticipante;
    Integer dni;
    String nombre;
    String apellido;
    Integer edad;
    String celular;
    String telefono;
    String grupoSanguineo;

    public Participante(Integer dni, Integer numeroParticipante, String nombre, String apellido, String celular, Integer edad, String telefono, String grupoSanguineo) {
        this.dni = dni;
        this.numeroParticipante = numeroParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.edad = edad;
        this.telefono = telefono;
        this.grupoSanguineo = grupoSanguineo;
    }
}
