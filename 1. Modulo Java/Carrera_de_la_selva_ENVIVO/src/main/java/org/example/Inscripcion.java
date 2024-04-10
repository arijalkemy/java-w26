package org.example;
import java.util.HashMap;
import java.util.Map;
public class Inscripcion {
    private static int contadorInscripcion = 1;
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.numeroInscripcion = contadorInscripcion++;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private int calcularMonto() {
        switch (categoria.getId()) {
            case 1: // Circuito chico
                return participante.getEdad() < 18 ? 1300 : 1500;
            case 2: // Circuito medio
                return participante.getEdad() < 18 ? 2000 : 2300;
            case 3: // Circuito avanzado
                if (participante.getEdad() < 18) {
                    throw new IllegalArgumentException("No se permite inscripciones a menores de 18 años en el Circuito Avanzado.");
                }
                return 2800;
            default:
                return 0;
        }
    }

    // Getters y setters
    public int getNumeroInscripcion() {
        return numeroInscripcion;
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

