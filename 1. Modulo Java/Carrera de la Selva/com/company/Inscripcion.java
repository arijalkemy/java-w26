package com.company;

public class Inscripcion {
    private final int monto;
    private final Participante participante;
    private final Categoria categoria;
    private final int numero;

    public Inscripcion(int numero, Categoria categoria, Participante participante){
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = categoria.getCostoFor(participante);
        if(monto > -1){
            categoria.recordInscription(this);
        }
    }

    public int getMonto() {
        return monto;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getNumero() {
        return numero;
    }
}
