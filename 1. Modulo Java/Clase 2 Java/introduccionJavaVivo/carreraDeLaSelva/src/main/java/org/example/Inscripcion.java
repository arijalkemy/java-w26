package org.example;

public class Inscripcion {
    private long nroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoTotal;

    public Inscripcion() {
    }

    public Inscripcion(long nroInscripcion, Categoria categoria, Participante participante) {
        this.nroInscripcion = nroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoTotal = calcularMontoTotal();
    }

    public long getNroInscripcion() {
        return nroInscripcion;
    }

    public void setNroInscripcion(long nroInscripcion) {
        this.nroInscripcion = nroInscripcion;
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

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }



    public double calcularMontoTotal(){
       return montoTotal=categoria.calcularCostoCategoria(participante.esMayor());
    }
    @Override
    public String toString() {
        return "Inscripcion{" +
                "nroInscripcion=" + nroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
