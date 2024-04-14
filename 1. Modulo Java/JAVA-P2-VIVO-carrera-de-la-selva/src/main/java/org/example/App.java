package org.example;

/**
 * ejercicio Carrera de la Selva
 */
public class App {
    public static void main(String[] args) {

        //creo un objeto de Categoria para cada circuito
        Categoria circuitoChico = new Categoria("circuito chico", "2 km por selva y arroyo", 1500, 1300);
        Categoria circuitoMedio = new Categoria("circuito medio", "5 km por selva, arroyo y barro", 2300, 2000);
        Categoria circuitoAvanzado = new Categoria("circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 2800, false);

        //creo un participante
        Participante pepe = new Participante("42722343", "pepe", "perez", 22, "1154423", 334, "A+");

        Participante mia = new Participante("30625917", "Mia", "Ramos", 40, "11292837", 129, "O+");

        Participante juancito = new Participante("40736743", "juancito", "Rodriguez", 12, "11382284", 129, "AB-");

        //inscribo el participante al circuitoChico
        circuitoChico.inscribirParticipante(pepe);
        circuitoChico.inscribirParticipante(pepe);
        circuitoChico.inscribirParticipante(juancito);
        circuitoMedio.inscribirParticipante(mia);
        circuitoAvanzado.inscribirParticipante(mia);
        circuitoAvanzado.inscribirParticipante(juancito);

        //mostrar lista de incriptos en todos los circuitos
        circuitoChico.mostrarParticipantes();
        circuitoMedio.mostrarParticipantes();
        circuitoAvanzado.mostrarParticipantes();

        //desinscribo participante
        circuitoChico.desinscribirParticipante(pepe);

        // muestro lo recaudado por cada categoria y el total de la carrera.
        double montoCircuitoChico = circuitoChico.getMontoRecaudado();
        double montoCircuitoMedio = circuitoMedio.getMontoRecaudado();
        double montoCircuitoAvanzado = circuitoAvanzado.getMontoRecaudado();

        System.out.println("\nLo recaudado por la categoria circuito chico fue: $" + montoCircuitoChico);
        System.out.println("\nLo recaudado por la categoria medio fue: $" + montoCircuitoMedio);
        System.out.println("\nLo recaudado por la categoria avanzado fue: $" + montoCircuitoAvanzado);

        System.out.println("\nLa carrera recaudo un total de: $" + (montoCircuitoChico + montoCircuitoMedio + montoCircuitoAvanzado));
    }
}
