package org.example;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante, double monto) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }

}
