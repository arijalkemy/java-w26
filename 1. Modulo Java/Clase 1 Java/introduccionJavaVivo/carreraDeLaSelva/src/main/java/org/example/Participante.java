package org.example;

public class Participante {
    private long nroParticipante;
    private long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String nroEmergencia;
    private String nroSanguineo;

    public Participante(long nroParticipante, long dni, String nombre, String apellido, int edad, String celular, String nroEmergencia, String nroSanguineo) {
        this.nroParticipante = nroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.nroSanguineo = nroSanguineo;
    }

    public long getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(long nroParticipante) {
        this.nroParticipante = nroParticipante;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
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

    public String getNroEmergencia() {
        return nroEmergencia;
    }

    public void setNroEmergencia(String nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public String getNroSanguineo() {
        return nroSanguineo;
    }

    public void setNroSanguineo(String nroSanguineo) {
        this.nroSanguineo = nroSanguineo;
    }
    public boolean esMayor(){
        boolean esMayor= false;
        if(edad>=18){
            esMayor=true;
        }
        return esMayor;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nroParticipante=" + nroParticipante +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", nroEmergencia='" + nroEmergencia + '\'' +
                ", nroSanguineo='" + nroSanguineo + '\'' +
                '}';
    }
}
