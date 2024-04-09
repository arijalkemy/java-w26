package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante juan = new Participante("123", "Juan", "Perez", 20, "1151231234", "1231421335", "0+");
        Participante john = new Participante("1234", "John", "Doe", 30, "1151231234", "1231421335", "0+");
        Participante jane = new Participante("4321", "Jane", "Doe", 31, "1151231234", "1231421335", "0+");
        List<Participante> participantes = new ArrayList<>();
        participantes.add(juan);
        participantes.add(john);
        participantes.add(jane);

        List<Inscripcion> inscripciones = new ArrayList<>();
        Inscripcion inscripcion1 = new Inscripcion(0, juan, circuitoChico);
        Inscripcion inscripcion2 = new Inscripcion(1, john, circuitoMedio);
        Inscripcion inscripcion3 = new Inscripcion(2, jane, circuitoAvanzado);
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);

        //for (int i = 0; i <= participantes.size(); i++) {
        //    Inscripcion i = new Inscripcion(i, participantes[i], 0)
        //    inscripciones.add(i);
        //}


        for (Inscripcion i : inscripciones) {
            System.out.println("Inscripción " + i.getNumero() + ": " + i.getParticipante().getNombre() + " " + i.getParticipante().getApellido() + " se inscribió en " + i.getCategoria().getNombre() + " con un monto de " + i.getMonto());
        }
    }


}

