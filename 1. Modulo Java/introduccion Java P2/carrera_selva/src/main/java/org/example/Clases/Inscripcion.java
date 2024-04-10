package org.example.Clases;

public class Inscripcion {
    private int numeroInscripcion; 
    private Categoria categoría;
    private Participante participante;
    private double monto;
    public Inscripcion(int numeroInscripcion, Categoria categoría, Participante participante, double monto) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoría = categoría;
        this.participante = participante;
        this.monto = monto;
    }
    public Inscripcion() {
    }
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }
    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
    public Categoria getCategoría() {
        return categoría;
    }
    public void setCategoría(Categoria categoría) {
        this.categoría = categoría;
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
        return "Inscripción:" + "\n" +
                "  Número de inscripción: " + numeroInscripcion + "\n" +
                categoría.toString() +
                participante.toString() +
                "  Monto: " + monto + "\n";
    }
    
}
