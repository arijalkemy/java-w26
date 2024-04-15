package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Inscripcion> listaDeInscripciones = new HashSet<>();

        Categoria circuitoChico = new Categoria("1", "Circuito chico", "2 km por selva y arroyos.", 1500, 1300);
        Categoria circuitoMedio = new Categoria("2", "Circuito medio", "5 km por selva, arroyos y barro.", 2300, 2000);
        Categoria circuitoAvanzado = new Categoria("3", "Circuito avanzado", "0 km por selva, arroyos, barro y escalada en piedra.", 2800, 0);

        Participante participanteUno = new Participante(1, 111, "Participante", "Uno", 21, 111, 111, "0");
        Participante participanteDos = new Participante(2, 111, "Participante", "Dos", 21, 111, 111, "0");
        Participante participanteTres = new Participante(3, 111, "Participante", "Tres", 21, 111, 111, "0");

        Inscripcion inscripcionUno = new Inscripcion(1, circuitoChico, participanteUno);
        Inscripcion inscripcionDos = new Inscripcion(2, circuitoMedio, participanteDos);
        Inscripcion inscripcionTres = new Inscripcion(3, circuitoAvanzado, participanteTres);

        listaDeInscripciones.add(inscripcionUno);
        listaDeInscripciones.add(inscripcionDos);
        listaDeInscripciones.add(inscripcionTres);

        System.out.println("Inscripcion participante: "+ inscripcionUno.participante.apellido + " monto a pagar: " + inscripcionUno.monto);

        List<Inscripcion> listaFiltrada = listaDeInscripciones.stream()
                .filter(elem -> elem.categoria.nombre.equals("Circuito chico")).toList();
    }
}





