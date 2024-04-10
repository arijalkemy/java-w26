package org.example;

public class Participante {
    String dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String celularEmergencia;
    String grupoSanguíneo;
    Categoria categoria;
    int numeroInscripcion = 0;

    public Participante(String dni, String nombre, String apellido, int edad, String celular, String celularEmergencia, String grupoSanguíneo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.celularEmergencia = celularEmergencia;
        this.grupoSanguíneo = grupoSanguíneo;
    }

    @Override
    public String toString(){
        return "\n\nInscripcion: " + this.numeroInscripcion +"\nDNI: " + this.dni + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nEdad: " + this.edad + "\nCelular: " + this.celular + "\nCelular de emergencia: " + this.celularEmergencia + "\nGrupo sanguíneo: " + this.grupoSanguíneo+ "\nCategoria: " + this.categoria.nombre;
    }
}
