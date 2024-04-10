package Inscripcion;

import Categorias.Categoria;
import Participante.Participante;

public class Inscripcion {
    private int nroInscripcion;
    private  Categoria categoria;
    private Participante participante;
    private double montoAAbonar;

    public Inscripcion(int nroInscripcion, Categoria categoria, Participante participante, double montoAAbonar) {
        this.nroInscripcion = nroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAAbonar = montoAAbonar;
    }

    @Override
    public String toString(){
        return "nroInscripcion: " + this.nroInscripcion + " categoria: " + categoria.getNombre() + " participante " +
                participante.getNombre() + " de " + participante.getEdad() + ", abonar: " + this.montoAAbonar;
    }

    public int getNroInscripcion() {
        return nroInscripcion;
    }

    public void setNroInscripcion(int nroInscripcion) {
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

    public double getMontoAAbonar() {
        return montoAAbonar;
    }

    public void setMontoAAbonar(double montoAAbonar) {
        this.montoAAbonar = montoAAbonar;
    }
}
