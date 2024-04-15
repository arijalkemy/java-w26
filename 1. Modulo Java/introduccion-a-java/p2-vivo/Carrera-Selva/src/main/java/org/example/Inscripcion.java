package org.example;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Competidor competidor;
    private double montoAbonar;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Competidor competidor) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.competidor = competidor;
        this.montoAbonar = calcularMonto(competidor.getEdad(), categoria);
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    private double calcularMonto(int edad, Categoria categoria) {
        if (edad < 18 && categoria.getNombre().equals("Avanzado"))
            throw new RuntimeException("No se puede inscribir a un menor de 18 años en la categoría Avanzado");

        if (edad < 18) return categoria.getMontoInscripcionMenorA18();
        return categoria.getMontoInscripcionMayorA18();
    }
}
