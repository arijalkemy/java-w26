package org.example;

public class Inscripcion {
    private Integer nro;
    private Categoria categoria;
    private Participante participante;
    private double montoPagado;

    public Inscripcion(Integer nro, Categoria categoria, Participante participante, double montoPagado) {
        this.nro = nro;
        this.categoria = categoria;
        this.participante = participante;
        this.montoPagado = montoPagado;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Integer getNro() {
        return nro;
    }
}
