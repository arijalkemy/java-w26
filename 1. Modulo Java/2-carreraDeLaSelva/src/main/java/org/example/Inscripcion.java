package org.example;

public class Inscripcion {

    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = montoAPagar();
    }

    public double montoAPagar() {
        return categoria.montoSegunEdad(participante.getEdad());
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
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcion --> " +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria.getNombre() +
                ", participante=" + participante.getNombre() + " " + participante.getApellido() + " - DNI: " + participante.getDni() +
                ", monto=" + monto;
    }
}
