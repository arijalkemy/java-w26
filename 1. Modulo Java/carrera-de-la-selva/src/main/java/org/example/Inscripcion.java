package org.example;

public class Inscripcion {
    private static int numero = 0;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(Participante participante,Categoria categoria) {
        ++this.numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public int calcularMonto() {

        switch (categoria.getId()) {
            case 1:
                return participante.getEdad() < 18 ? 1300 : 1500;
            case 2:
                return participante.getEdad() < 18 ? 2000 : 2300;
            case 3:
                if (this.participante.getEdad() < 18) {
                    throw new IllegalArgumentException("No se permiten inscripciones a menores de 18 años en el Cirucito Avanzado.");
                }
                return 2800;
            default:
                return 0;
        }

    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "participante=" + participante +
                ", monto=" + monto
                ;
    }
}
