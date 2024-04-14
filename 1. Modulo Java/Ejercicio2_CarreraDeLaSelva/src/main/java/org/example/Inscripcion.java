package org.example;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAbono;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, double montoAbono) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAbono = montoAbono;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(double montoAbono) {
        this.montoAbono = montoAbono;
    }
}
