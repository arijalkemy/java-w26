package org.example;

class Participante {
    int numero;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numeroEmergencia;
    String grupoSanguineo;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, int celular,
                        int numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
