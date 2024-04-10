package org.example;

public class Inscripcion {
    private static int CONTADOR = 0;
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.numeroInscripcion = CONTADOR++;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = this.calcularMonto();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    private int calcularMonto(){
        int monto = 0;
        switch (this.categoria.getId()){
            case 0:
                monto = (this.participante.getEdad() < 18) ? 1300 : 1500;
                break;
            case 1:
                monto = (this.participante.getEdad() < 18) ? 2000 : 2300;
                break;
            case 2:
                monto = 2800;
                break;
        }
        return monto;
    }

    public static boolean sePuedeInscribir(Participante participante, Categoria categoria){
        return !(participante.getEdad() < 18 && categoria.getId() == 2);
    }

    public Participante getParticipante() {
        return participante;
    }

    public int getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
