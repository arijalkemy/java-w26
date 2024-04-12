package org.example;

import java.util.Objects;
import java.util.Random;

public class Inscripcion {
    Integer idInscripcion;
    Categoria categoria;
    Participante participante;
    Integer precio;

    public Inscripcion(Integer idInscripcion, Categoria categoria, Participante participante, Integer precio) {
        this.idInscripcion = idInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.precio = precio;
    }

    public static Inscripcion inscribirParticipante(Participante participante, Categoria categoria) {
        int monto = 0;

        if(Objects.equals(categoria.nombre, "CircuitoChico")){
            if(participante.edad < 18) {
                monto = 1300;
            }else{
                monto = 1500;
            }
        }else if(Objects.equals(categoria.nombre, "CircuitoMedio")){
            if(participante.edad < 18) {
                monto = 2000;
            }else{
                monto = 2300;
            }
        }else if(Objects.equals(categoria.nombre, "CircuitoGrande")){
            if(participante.edad < 18) {
                System.out.println("No se permiten menores de 18");
            }else{
                monto = 2800;
            }
        }
    Random rand = new Random();
    int numeroInscripcion = rand.nextInt(10);
    Inscripcion inscripcionFinal = new Inscripcion(numeroInscripcion, categoria, participante, monto);
    return inscripcionFinal;
    }
}
