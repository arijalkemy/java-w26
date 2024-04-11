package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void inscribirParticipante(int numeroDeInscripcion, Participante participante, Categoria categoria) {
        if(categoria.getEdadMinima() != null) {
            if(participante.getEdad() < categoria.getEdadMinima()) {
                System.out.println("El participante no puede inscribirse a la categoria " + categoria.getNombre() + " porque no tiene la edad mínima requerida.");
            } else {
                Inscripcion nuevaInscripcion = new Inscripcion(numeroDeInscripcion, categoria, participante);
                this.inscripciones.add(nuevaInscripcion);
            }
        } else {
            Inscripcion nuevaInscripcion = new Inscripcion(numeroDeInscripcion, categoria, participante);
            this.inscripciones.add(nuevaInscripcion);
        }
    }

    public void mostrarParticipantesDeCategoria(Categoria categoria){
        System.out.println("Los inscriptos a la categoria " + categoria.getNombre() + " son:");
        for(Inscripcion inscripcion : this.inscripciones) {
            if(inscripcion.getCategoria().getId() == categoria.getId()) {
                System.out.println(inscripcion.getParticipante().toString());
            }
        }
    }

    public void desinscribirParticipante(Participante participante){
        for(int i = 0; i < this.inscripciones.size(); i++) {
            if(this.inscripciones.get(i).getParticipante().getNumeroDeParticipante() == participante.getNumeroDeParticipante()) {
                this.inscripciones.remove(i);
                break;
            }
        }
    }

    public int getMontoRecaudadoPorCategoria(Categoria categoria) {
        int montoTotal = 0;
        for(Inscripcion inscripcion : inscripciones) {
            if(inscripcion.getCategoria().getId() == categoria.getId()) {
                montoTotal = montoTotal + inscripcion.getMonto();
            }
        }
        return montoTotal;
    }

    public int getMontoTotalRecaudado() {
        int montoTotal = 0;
        for(Inscripcion inscripcion : inscripciones) {
            montoTotal = montoTotal + inscripcion.getMonto();
        }
        return montoTotal;
    }
}
