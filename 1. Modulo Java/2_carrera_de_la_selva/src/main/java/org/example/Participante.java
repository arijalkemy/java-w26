package org.example;

public class Participante {

    private int nroParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String telefonoEmergencia;
    private String grupoSanguineo;
    private static int nroParticipanteCounter;


    public Participante(String dni,
                        String nombre,
                        String apellido,
                        int edad,
                        String telefono,
                        String telefonoEmergencia,
                        String grupoSanguineo
    ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.nroParticipante = Participante.nroParticipanteCounter++;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(int nroParticipante) {
        this.nroParticipante = nroParticipante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nroParticipante=" + nroParticipante +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", telefonoEmergencia='" + telefonoEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
