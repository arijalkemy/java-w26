package com.company;

public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private float monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto(participante.getEdad(), categoria.getId());
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public float getMonto() {
        return monto;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    private float calcularMonto(int edad, int idCategoria) {
        if (idCategoria == 0) {
            if (edad >= 18)
                return 1500;
            else return 1300;
        }
        if (idCategoria == 1) {
            if (edad >= 18)
                return 2300;
            else return 2000;
        }
        return  2800;
    }
}
