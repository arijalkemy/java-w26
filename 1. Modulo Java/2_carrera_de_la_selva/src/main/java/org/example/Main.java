package org.example;


public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera("Carrera de la selva");

        // item a) ------------------------
        Categoria circuitoChico = new Categoria(0, "Circuito chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(1, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(2, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        // item b) ------------------------
        Participante p1 = new Participante(
                "40620000",
                "Matias",
                "Pinto",
                26,
                "+5491233333",
                "+9911122233",
                "0+"
        );
        carrera.inscribirParticipante(circuitoChico, p1);
        System.out.println();

        // item c) ------------------------
        Participante p2 = new Participante(
                "4111111",
                "Nicolas",
                "Rodriguez",
                17,
                "+5491233333",
                "+9911122233",
                "B+"
        );
        Participante p3 = new Participante(
                "42222222",
                "Juan Cruz",
                "Pepin",
                20,
                "+5491233333",
                "+9911122233",
                "B-"
        );
        Participante p4 = new Participante(
                "4999999",
                "Valeria",
                "Ostachuk",
                12,
                "+5491233333",
                "+9911122233",
                "0-"
        );
        carrera.inscribirParticipante(circuitoMedio, p2);
        carrera.inscribirParticipante(circuitoAvanzado, p3);
        carrera.inscribirParticipante(circuitoChico, p4);
        System.out.println();

        // item d) ------------------------
        // Traigo las inscripciones con id 0, es decir, las del circuito chico
        System.out.println("Inscripciones del circuito chico:");
        System.out.println(carrera.getInscripciones(0));
        System.out.println("---");
        System.out.println("Inscripciones totales:");
        System.out.println(carrera.getInscripciones());

        // item e) ------------------------
        System.out.println();
        System.out.println("Elimino del circuito chico al participante con id 3");
        carrera.eliminarParticipante(3);
        System.out.println("Y me queda esa categoria:");
        System.out.println(carrera.getInscripciones(0));
        System.out.println();

        // item f) ------------------------
        carrera.calcularMontosTotales();
    }
}