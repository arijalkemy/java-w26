package org.example;

import java.util.HashMap;

public class Inscripciones {
    private HashMap<Integer, Inscripcion> inscripciones;

    public Inscripciones() {
        this.inscripciones = new HashMap<Integer, Inscripcion>();
    }

    public void inscribir(int numeroInscripcion, Categoria categoria, Competidor competidor) {
        if (competidor.estaInscripto()) {
            throw new RuntimeException("El competidor ya se encuentra inscripto");
        }

        Inscripcion inscripcion = new Inscripcion(numeroInscripcion, categoria, competidor);
        inscripciones.put(numeroInscripcion, inscripcion);
        competidor.inscribir();
    }

    public void desinscribir(int numeroInscripcion) {
        if (!inscripciones.containsKey(numeroInscripcion)) {
            throw new RuntimeException("La inscripción no existe");
        }

        inscripciones.get(numeroInscripcion).getCompetidor().desinscribir();
        inscripciones.remove(numeroInscripcion);
    }

    public double getMontoAbonar(int numeroCompetidor) {
        return inscripciones.get(numeroCompetidor).getMontoAbonar();
    }

    public void verListaDeInscriptos() {
        for (Inscripcion inscripcion : inscripciones.values()) {
            System.out.println(inscripcion.getCompetidor().getNombre() + " " + inscripcion.getCompetidor().getApellido() + " - " + inscripcion.getCategoria().getNombre() + " - " + inscripcion.getCategoria().getDescripcion());
        }
    }

    public void calcularRecaudacion() {
        HashMap<String, Double> recaudacionPorCategoria = new HashMap<String, Double>();
        double recaudacionTotal = 0.0;
        for (Inscripcion inscripcion : inscripciones.values()) {
            recaudacionPorCategoria.put(inscripcion.getCategoria().getNombre(), recaudacionPorCategoria.getOrDefault(inscripcion.getCategoria().getNombre(), 0.0) + inscripcion.getMontoAbonar());
            recaudacionTotal += inscripcion.getMontoAbonar();
        }

        for (String categoria : recaudacionPorCategoria.keySet()) {
            System.out.println("Categoría: " + categoria + " - Recaudación: $" + recaudacionPorCategoria.get(categoria));
        }

        System.out.println("Recaudación total: $" + recaudacionTotal);
    }
}
