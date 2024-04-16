package org.example;

public class Participante {
    int NroParticipante;
    int Dni;
    int Edad;
    int Celular;
    int NumeroEmergencia;
    String GrupoSanguineo;
    String Nombre;
    String Apellido;

    public Participante(int nroParticipante, int dni, int edad, int celular, int nroEmergencia, String nombre, String apellido, String grupoSanguineo){
        NroParticipante = nroParticipante;
        Dni = dni;
        Edad = edad;
        Celular = celular;
        NumeroEmergencia = nroEmergencia;
        GrupoSanguineo = grupoSanguineo;
        Nombre = nombre;
        Apellido = apellido;
    }
}
