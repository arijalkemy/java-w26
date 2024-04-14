package org.example;

public class Participante {

    private int numero;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroDeEmergencia;
    private String grupoSanguineo;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, int celular, int numeroDeEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return
                "numero=" + numero +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroDeEmergencia=" + numeroDeEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'';
    }
}
