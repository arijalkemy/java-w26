package org.example;

public class Participante {
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
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

    public String getCelular() {
        return celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numero=" + numero +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", numeroEmergencia='" + numeroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
