package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private List<Participante> participantes;
    private List<Inscripcion> inscripciones;

    private List<Categoria> categorias;

    public Carrera() {
        this.participantes = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void agregarCategoria(Categoria... categorias) {
        for (Categoria c : categorias) {
            this.categorias.add(c);
        }
    }

    public void inscribirParticipante(Participante participante, Categoria categoria) {
        this.inscripciones.add(new Inscripcion(participante, categoria));
        this.participantes.add(participante);
    }

    public void desinscribirParticipante(Participante participante) {
        Inscripcion inscripcion = inscripciones.stream().filter(
                i -> i.getParticipante().equals(participante)
        ).findFirst().orElseThrow(() -> new IllegalArgumentException(
                "El participante no se encuentra inscripto en la carrera."));

        inscripciones.remove(inscripcion);
        participantes.remove(participante);
        System.out.println("El participante " + participante + " fue eliminado.");
    }


    public double calcularTotalPorCategoria(Categoria categoria) {
        return this.inscripciones.stream()
                .filter(c -> c.getCategoria().equals(categoria))
                .mapToDouble(c->c.getMonto()).sum();
    }

    public String calcularTotalCarrera() {
        return "TOTAL POR CATEGORIA: " + this.inscripciones.stream().mapToDouble(i -> i.getMonto()).sum();
    }

    public void mostrarInsriptos(Categoria c)
    {
        System.out.println("Inscriptos en la categoria " + c.getNombre() + ":");
        this.inscripciones.stream().filter(i->i.getCategoria().equals(c)).forEach(System.out::println);
    }

}
