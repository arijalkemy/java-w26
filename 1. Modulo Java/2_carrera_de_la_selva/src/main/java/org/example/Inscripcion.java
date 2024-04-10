package org.example;

public class Inscripcion {

    private static int numIncripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.categoria = categoria;
        this.participante = participante;
        Inscripcion.numIncripcion++;
        this.monto = setMonto();
    }

    public int setMonto(){
        switch (this.categoria.getId()){
            case 0:
                return (this.participante.getEdad() > 18) ? 1500 : 1300;
            case 1:
                return (this.participante.getEdad() > 18) ? 2300 : 2000;
            case 2:
                return (this.participante.getEdad() > 18) ? 2800 : -1;
            default:
                return -1;
        }
    }

    public static int getNumIncripcion() {
        return numIncripcion;
    }

    public static void setNumIncripcion(int numIncripcion) {
        Inscripcion.numIncripcion = numIncripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                "}\n";
    }
}
