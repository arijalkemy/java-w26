package org.example.clases;

public class Inscripcion {

    private static int ultimoNumeroInscripcion = 1;

    private final int numeroInscripcion;
    private final Categoria categoria;
    private final Participante participante;
    private final double montoInscripcion;


    public Inscripcion(Categoria categoria, Participante participante) {
        this.numeroInscripcion = ultimoNumeroInscripcion++;
        this.categoria = categoria;
        this.participante = participante;
        this.montoInscripcion = categoria.calcularMontoInscripcion(participante);
    }


    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMontoInscripcion() {
        return montoInscripcion;
    }
}
