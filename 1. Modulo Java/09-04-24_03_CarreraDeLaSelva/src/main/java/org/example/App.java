package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    private static final List<Categoria> categorias = new ArrayList<>();
    private static final List<Inscripcion> inscripciones = new ArrayList<>();
    private static int inscripcionCounter = 1;
    private static int participanteCounter = 1;

    public static void main(String[] args) {
        // Crear categorías
        crearCategorias();

        // Crear y mostrar inscripciones
        inscribirParticipante(new Participante(participanteCounter++, "12345678", "Juan", "Perez", 21, "123456789", "987654321", "A+"), categorias.get(0));
        inscribirParticipante(new Participante(participanteCounter++, "23456789", "Ana", "Gomez", 17, "234567890", "876543210", "B+"), categorias.get(1));
        inscribirParticipante(new Participante(participanteCounter++, "34567890", "Carlos", "Lopez", 30, "345678901", "765432109", "O-"), categorias.get(2));

        // Inscribir aleatoriamente algunos participantes
        inscribirAleatoriamente();

        // Mostrar inscripciones de una categoría específica
        mostrarInscripcionesPorCategoria(categorias.get(0));

        // Desinscribir a un participante y mostrar la lista resultante
        desinscribirParticipante(1);
        mostrarInscripcionesPorCategoria(categorias.get(0));

        // Calcular montos recaudados
        calcularMontoTotal();
    }

    private static void crearCategorias() {
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos."));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro."));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));
    }

    private static void inscribirParticipante(Participante participante, Categoria categoria) {
        Inscripcion inscripcion = new Inscripcion(inscripcionCounter++, categoria, participante);
        inscripciones.add(inscripcion);
        System.out.println("Inscripción exitosa: " + inscripcion);
    }

    private static void inscribirAleatoriamente() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int edad = 15 + random.nextInt(30);
            Participante participante = new Participante(participanteCounter++, "DNI" + i, "Nombre" + i, "Apellido" + i, edad, "12345" + i, "54321" + i, "A+");
            Categoria categoria = categorias.get(random.nextInt(categorias.size()));
            if (categoria.getNombre().equals("Circuito avanzado") && edad < 18) continue; // Evitar menores en Circuito avanzado
            inscribirParticipante(participante, categoria);
        }
    }

    private static void mostrarInscripcionesPorCategoria(Categoria categoria) {
        List<Inscripcion> inscripcionesPorCategoria = inscripciones.stream()
                .filter(inscripcion -> inscripcion.getCategoria().equals(categoria))
                .collect(Collectors.toList());

        System.out.println("Inscripciones para la categoría: " + categoria.getNombre());
        for (Inscripcion inscripcion : inscripcionesPorCategoria) {
            System.out.println(inscripcion);
        }
    }

    private static void desinscribirParticipante(int numeroInscripcion) {
        inscripciones.removeIf(inscripcion -> inscripcion.getNumeroInscripcion() == numeroInscripcion);
        System.out.println("Participante desinscripto. Número de inscripción: " + numeroInscripcion);
    }

    private static void calcularMontoTotal() {
        double totalRecaudadoChico = calcularMontoPorCategoria("Circuito chico");
        double totalRecaudadoMedio = calcularMontoPorCategoria("Circuito medio");
        double totalRecaudadoAvanzado = calcularMontoPorCategoria("Circuito avanzado");

        double totalRecaudado = totalRecaudadoChico + totalRecaudadoMedio + totalRecaudadoAvanzado;

        System.out.println("Total recaudado en Circuito chico: $" + totalRecaudadoChico);
        System.out.println("Total recaudado en Circuito medio: $" + totalRecaudadoMedio);
        System.out.println("Total recaudado en Circuito avanzado: $" + totalRecaudadoAvanzado);
        System.out.println("Total recaudado en toda la carrera: $" + totalRecaudado);
    }

    private static double calcularMontoPorCategoria(String nombreCategoria) {
        return inscripciones.stream()
                .filter(inscripcion -> inscripcion.getCategoria().getNombre().equals(nombreCategoria))
                .mapToDouble(Inscripcion::getMonto)
                .sum();
    }
}
