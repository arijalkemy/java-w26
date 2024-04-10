package com.company;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private int costoMenor;
    private int costoMayor;
    private int id;
    private String nombre;
    private String descripcion;
    private Set<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion, int costoMayor, int costoMenor){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMayor = costoMayor;
        this.costoMenor = costoMenor;
        this.inscripciones = new HashSet<Inscripcion>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCostoFor(Participante participante) {
        return participante.recordInscriptionTo(this);
    }

    public int getCostoMenor() {
        return costoMenor;
    }

    public int getCostoMayor() {
        return costoMayor;
    }

    public Set<Inscripcion> getinscripciones() {
        return inscripciones;
    }

    public void recordInscription(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public void inscribir(int numero, Participante participante) {
        participante.asignarCategoria(this);
        new Inscripcion(numero, this, participante);
    }

    public void desuscribir(Participante participante) {
        participante.dejarSinCategoria();
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getParticipante().equals(participante)){
                inscripciones.remove(inscripcion);
                break;
            }
        }
    }

    public void mostrarInfoDeInscriptosActuales() {
        System.out.println("INFO DE " + nombre);
        for(Inscripcion inscripcion : inscripciones){
            System.out.println(inscripcion.getNumero() + ". " + inscripcion.getParticipante().infoDeParticipante() + ".\n");
        }
    }

    public int montoTotal() {
        int montoActual = 0;
        for(Inscripcion inscripcion : inscripciones){
            montoActual += inscripcion.getMonto();
        }
        return montoActual;
    }
}
