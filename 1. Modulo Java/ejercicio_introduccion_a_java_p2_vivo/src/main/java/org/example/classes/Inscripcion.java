package org.example.classes;

public class Inscripcion {
    private int numeroDeInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numeroDeInscripcion, Categoria categoria, Participante participante) {
        this.numeroDeInscripcion = numeroDeInscripcion;
        this.categoria = categoria;
        this.participante = participante;

        switch (categoria.getNombre()) {
            case "Circuito Chico":
                if(participante.getEdad() < 18){
                    this.monto = 1300;
                } else {
                    this.monto = 1500;
                }
                break;
            case "Circuito Medio":
                if(participante.getEdad() < 18){
                    this.monto = 2000;
                } else {
                    this.monto = 2300;
                }
                break;
            case "Circuito Avanzado":
                this.monto = 2800;
        }
    }

    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
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

