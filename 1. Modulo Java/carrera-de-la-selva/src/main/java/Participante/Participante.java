package Participante;

import java.time.LocalDate;

public class Participante {
    private int nroParticipante;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeCumpleaños;
    private String celular;
    private String nroDeEmergencia;
    private String grupoSanguineo;
    private String dni;

    public Participante(int nroParticipante, String nombre, String apellido, LocalDate fechaDeCumpleaños, String celular, String nroDeEmergencia, String grupoSanguineo, String dni) {
        this.nroParticipante = nroParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeCumpleaños = fechaDeCumpleaños;
        this.celular = celular;
        this.nroDeEmergencia = nroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.dni = dni;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(int nroParticipante) {
        this.nroParticipante = nroParticipante;
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

    public LocalDate getFechaDeCumpleaños() {
        return fechaDeCumpleaños;
    }

    public void setFechaDeCumpleaños(LocalDate fechaDeCumpleaños) {
        this.fechaDeCumpleaños = fechaDeCumpleaños;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNroDeEmergencia() {
        return nroDeEmergencia;
    }

    public void setNroDeEmergencia(String nroDeEmergencia) {
        this.nroDeEmergencia = nroDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad(){
        return LocalDate.now().minusYears(fechaDeCumpleaños.getYear()).getYear();
    }
}
