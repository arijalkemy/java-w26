package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Se instancian las categorias
        Categoria circuitoChico = new Categoria(0,
                "Circuito chico",
                "2 km por selva y arroyos",
                true);
        Categoria circuitoMedio = new Categoria(1,
                "Circuito medio",
                "5 km por selva, arroyos y barro",
                true);
        Categoria circuitoAvanzado = new Categoria(2,
                "Circuito avanzado",
                "10 km por selva, arroyos, barro y escalada en piedra",
                false);

        // Se instancia la lista de inscripciones
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        // Se inscriben los participantes y se añaden a la lista de inscripciones
        Participante participante1 = new Participante(0,
                12345678,
                "Carlos",
                "Gonzalez",
                29,
                123456789,
                123456788,
                "0+"
                );

        Inscripcion inscripcion1 = new Inscripcion(0, circuitoChico, participante1);

        inscripciones.add(inscripcion1);

        Participante participante2 = new Participante(1,
                12345678,
                "Jose",
                "Perez",
                17,
                123456789,
                123456788,
                "A+"
        );

        Inscripcion inscripcion2 = new Inscripcion(1, circuitoChico, participante2);

        inscripciones.add(inscripcion2);

        Participante participante3 = new Participante(2,
                12345678,
                "Ernesto",
                "Tevez",
                15,
                123456789,
                123456788,
                "A+"
        );

        Inscripcion inscripcion3 = new Inscripcion(2, circuitoMedio, participante3);

        inscripciones.add(inscripcion3);

        Participante participante4 = new Participante(3,
                12345678,
                "Julian",
                "Martino",
                25,
                123456789,
                123456788,
                "A+"
        );

        Inscripcion inscripcion4 = new Inscripcion(3, circuitoMedio, participante4);

        inscripciones.add(inscripcion4);

        Participante participante5 = new Participante(4,
                12345678,
                "Carlos",
                "Palermo",
                20,
                123456789,
                123456788,
                "A+"
        );

        Inscripcion inscripcion5 = new Inscripcion(4, circuitoAvanzado, participante5);

        inscripciones.add(inscripcion5);

        Participante participante6 = new Participante(5,
                12345678,
                "Jose",
                "Perez",
                27,
                123456789,
                123456788,
                "A+"
        );

        Inscripcion inscripcion6 = new Inscripcion(5, circuitoAvanzado, participante6);

        inscripciones.add(inscripcion6);

        System.out.println("Inscriptos " + circuitoChico.getNombre());
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 0) {
                System.out.println(" - " + inscripcion.getParticipante().toString());
                System.out.println("   Número de inscripción: " + inscripcion.getNumeroInscripcion());
            }
        }

        System.out.println("\nInscriptos " + circuitoMedio.getNombre());
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 1) {
                System.out.println(" - " + inscripcion.getParticipante().toString());
                System.out.println("   Número de inscripción: " + inscripcion.getNumeroInscripcion());
            }
        }

        System.out.println("\nInscriptos " + circuitoAvanzado.getNombre());
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 2) {
                System.out.println(" - " + inscripcion.getParticipante().toString());
                System.out.println("   Número de inscripción: " + inscripcion.getNumeroInscripcion());
            }
       }

        // Se desinscribe al primer participante inscripto
        System.out.println("\nSe elimina la inscripción del participante con id:0");
        inscripciones.remove(0);
        System.out.println("Inscriptos " + circuitoChico.getNombre());
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 0) {
                System.out.println(" - " + inscripcion.getParticipante().toString());
                System.out.println("   Número de inscripción: " + inscripcion.getNumeroInscripcion());
            }
        }

        // Monto total recaudado por cada categría
        float montoCategoria1 = 0;
        float montoCategoria2 = 0;
        float montoCategoria3 = 0;

        for(Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 0) montoCategoria1 += inscripcion.getMonto();
            if (inscripcion.getCategoria().getId() == 1) montoCategoria2 += inscripcion.getMonto();
            if (inscripcion.getCategoria().getId() == 2) montoCategoria3 += inscripcion.getMonto();
        }

        float montoTotal = montoCategoria1 + montoCategoria2 + montoCategoria3;

        System.out.println("\nMonto total recaudado por cada categoría:");
        System.out.println(" - Categoría Circuito Chico: $" + montoCategoria1);
        System.out.println(" - Categoría Circuito Medio: $" + montoCategoria2);
        System.out.println(" - Categoría Circuito Avanzado: $" + montoCategoria3);
        System.out.println("\nMonto total recaudado: $" + montoTotal);
    }
}
