package org.example;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numero, Participante participante, Categoria categoria) {
        this.numero = numero;
        this.participante = participante;
        this.categoria = categoria;
        if(!categoria.puedeInscribirse(participante)) {
            Object Error;
            Error = new Error();
        }
        this.monto = categoria.montoAPagarPor(participante);
    }
    public int getNumero() {
        return numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public int getMonto() {
        return monto;
    }
}
