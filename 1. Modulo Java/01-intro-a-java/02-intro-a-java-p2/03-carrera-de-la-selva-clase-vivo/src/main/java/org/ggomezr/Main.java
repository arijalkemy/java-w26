package org.ggomezr;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//      Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        Categoria categoriaChica = new Categoria("Circuito chico", "2 km por selva y arroyos.");
        Categoria categoriaMedia = new Categoria("Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoriaAvanzada = new Categoria("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

//      Crear participantes
        Participante participante1 = new Participante(12313, "Geraldine", "Gomez", 20, 3193108099L, "AB+");
        Participante participante2 = new Participante(23233, "Sandra", "Romero", 17, 3012128807L, "A+");
        Participante participante3 = new Participante(45454, "Sebastian", "Rodriguez", 28, 1234567890L, "O+");
        Participante participante4 = new Participante(22231, "Jennifer", "Gomez", 15, 31212676901L, "O+");

//      Lista de inscripciones
        List<Inscripcion> inscripciones = new ArrayList<>();

//      Creacion de inscripciones
        Inscripcion inscripcion1 = new Inscripcion(categoriaChica, participante1);
        Inscripcion inscripcion2 = new Inscripcion(categoriaMedia, participante2);
        Inscripcion inscripcion3 = new Inscripcion(categoriaAvanzada, participante3);
        Inscripcion inscripcion4 = new Inscripcion(categoriaChica, participante4);

//      Inscripciones agregadas a la lista de inscripciones
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);

//      Calcular el monto de inscripcion que debera abonar el participante
        System.out.println("Abono participante " + inscripcion1.getParticipante().getNombre() + " a la categoria " + inscripcion1.getCategoria().getNombre() + ": $" + inscripcion1.getAbonoParticipante());

//      Mostrar los inscritos a el circuito chico
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoria().getNombre().equalsIgnoreCase("Circuito chico")){
                System.out.println(inscripcion);
            }
        }

//      Mostrar la lista de inscripciones completa
        System.out.println(inscripciones);

//      Quitar el primer elemento de la lista de inscripciones
        inscripciones.remove(0);

//      Mostrar la lista de inscripciones despues de quitar el primer elemento
        System.out.println(inscripciones);

//      Inicializar variables para el calculo de los montos de los circuitos
        int totalMontoCircuitoChico = 0;
        int totalMontoCircuitoMedio = 0;
        int totalMontoCircuitoAvanzado = 0;
        int totalMontoCategorias = 0;


//        Recorrer la lista de inscripciones y calcular el monto total por categoria
        for(Inscripcion inscripcion : inscripciones){
//            Calcular el total recaudado de toda la carrera con todas las categorias
            totalMontoCategorias += inscripcion.getAbonoParticipante();
            if(inscripcion.getCategoria().getNombre().equalsIgnoreCase("Circuito chico")){
                totalMontoCircuitoChico += inscripcion.getAbonoParticipante();
            }else if(inscripcion.getCategoria().getNombre().equalsIgnoreCase("Circuito medio")){
                totalMontoCircuitoMedio += inscripcion.getAbonoParticipante();
            } else {
                totalMontoCircuitoAvanzado += inscripcion.getAbonoParticipante();
            }
        }

//      Mostrar los valores de los totales de los montos
        System.out.println("Total monto recaudado para el circuito chico: " + totalMontoCircuitoChico);
        System.out.println("Total monto recaudado para el circuito medio: " + totalMontoCircuitoMedio);
        System.out.println("Total monto recaudado para el circuito avanzado: " + totalMontoCircuitoAvanzado);
        System.out.println("Total monto recaudado de todas las categorias: " + totalMontoCategorias);
    }
}