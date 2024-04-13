package co.com.mercadolibre;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Crear objetos de tipo categoría
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crear una lista de participantes
        List<Participante> participantes = new ArrayList<Participante>();
        participantes.add(new Participante(1, "12345678", "Juan", "Pérez", 21, "555-1234", "555-5678", "A+"));
        participantes.add(new Participante(2, "98765432", "María", "González", 19, "555-4321", "555-8765", "B-"));

        // Asignar categorías aleatoriamente
        Random random = new Random();
        for (Participante participante : participantes) {
            int categoriaAleatoria = random.nextInt(3);
            switch (categoriaAleatoria) {
                case 0:
                    participante.setCategoria(circuitoChico);
                    break;
                case 1:
                    participante.setCategoria(circuitoMedio);
                    break;
                case 2:
                    participante.setCategoria(circuitoAvanzado);
                    break;
            }
        }

        // Mostrar los participantes inscritos
        System.out.println("Participantes inscritos:");
        for (Participante participante : participantes) {
            System.out.println(participante.getNombre() + " " + participante.getApellido() +
                    " (Categoría: " + participante.getCategoria().getNombre() + ") " + participante.calcularMontoInscripcion(participante.getCategoria()));
        }

        calcularMontos(participantes);

        desinscribirParticipante(participantes, 1);
    }

    public static void desinscribirParticipante(List<Participante> participantes, int numeroParticipante) {
        for (Participante p : participantes) {
            if (p.getNumeroInscripcion() == numeroParticipante) {
                participantes.remove(p);
                System.out.println("Participante desinscrito: " + p.getNombre() + " " + p.getApellido());
                break;
            }
        }
    }

    public static void calcularMontos(List<Participante> participantes) {
        double totalGeneral = 0.0;
        Map<String, Double> montosPorCategoria = new HashMap<String, Double>();

        for (Participante p : participantes) {
            double monto = p.calcularMontoInscripcion(p.getCategoria());
            totalGeneral += monto;

            String categoria = p.getCategoria().getNombre();
            montosPorCategoria.put(categoria, montosPorCategoria.containsKey(categoria) ? montosPorCategoria.get(categoria) + monto : 0.0);
        }

        // Mostrar montos por categoría
        System.out.println("\nMontos recaudados por categoría:");
        for (Map.Entry<String, Double> entry : montosPorCategoria.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println("\nTotal recaudado (general): $" + totalGeneral);
    }

}
