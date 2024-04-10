package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creación de categorías
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Creación de participantes
        Participante participante1 = new Participante(1, "12345678", "Juan", "Pérez", 20, "1122334455", "1133221100", "O+");
        Participante participante2 = new Participante(2, "87654321", "Ana", "Gomez", 17, "1166778899", "1199887766", "A-");

        // Inicialización de la carrera
        Carrera carrera = new Carrera();

        // Agregando categorías a la carrera
        carrera.agregarCategoria(circuitoChico);
        carrera.agregarCategoria(circuitoMedio);
        carrera.agregarCategoria(circuitoAvanzado);

        // Inscribiendo participantes
        carrera.inscribirParticipante(participante1, circuitoChico);
        carrera.inscribirParticipante(participante2, circuitoMedio);

        // Mostrar participantes por categoría
        System.out.println("Participantes en Circuito Chico:");
        carrera.mostrarParticipantesPorCategoria(1);

        System.out.println("Participantes en Circuito Medio:");
        carrera.mostrarParticipantesPorCategoria(2);

        // Desinscribir a un participante y mostrar la lista actualizada
        carrera.desinscribirParticipante(1);
        System.out.println("Participantes en Circuito Chico después de desinscripción:");
        carrera.mostrarParticipantesPorCategoria(1);

        // Calcular total recaudado
        carrera.calcularRecaudos();
    }
}