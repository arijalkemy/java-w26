package org.example;

class Inscripcion {
    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = montoAPagar();
    }

    public int montoAPagar(){
        return categoria.valor(participante.edad);
    }
}
