package org.example;

import org.example.clases.Categoria;
import org.example.clases.Inscripcion;
import org.example.clases.Participante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    private static final List<Categoria> categorias = new ArrayList<>();
    private static final List<Inscripcion> inscripciones = new ArrayList<>();


    public static void main(String[] args) {

        /*
         a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
         */
        categorias.add(new Categoria(
            1,
            "Circuito chico",
            "2 km por selva y arroyos",
            participante -> participante.getEdad() < 18 ? 1300.0 : 1500.0
        ));
        categorias.add(new Categoria(
            2,
            "Circuito medio",
            "5 km por selva, arroyos y barro",
            participante -> participante.getEdad() < 18 ? 2000.0 : 2300.0
        ));
        categorias.add(new Categoria(
            3,
            "Circuito avanzado",
            "5 km por selva, arroyos, barro y escalada en piedra",
            participante -> {
                if (participante.getEdad() < 18)
                    throw new RuntimeException("No se permiten menores de edad en esta categoría");

                return 2800.0;
            }
        ));

        /*
         b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción
         que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años,
         el monto a abonar es de $1500).
         c) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
         */
        Participante participante1 = new Participante("12345678", "Juan", "Perez", 20, "123456789", "A+");
        inscripciones.add(new Inscripcion(categorias.get(0), participante1));

        Participante participante2 = new Participante("87654321", "Maria", "Gomez", 15, "987654321", "B-");
        inscripciones.add(new Inscripcion(categorias.get(1), participante2));

        Participante participante3 = new Participante("11111111", "Pedro", "Rodriguez", 25, "111111111", "AB+");
        inscripciones.add(new Inscripcion(categorias.get(2), participante3));

        Participante participante4 = new Participante("22222222", "Ana", "Fernandez", 17, "222222222", "0-");
        inscripciones.add(new Inscripcion(categorias.get(0), participante4));

        /*
         d) Mostrar por pantalla todos los inscriptos a una determinada categoría
         con sus correspondientes datos y número de inscripción.
         */
        imprimirInscripcionesPorCategoria(1);

        /*
         e) Desinscribir a un participante.
         Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
         */
        inscripciones.remove(0);
        imprimirInscripcionesPorCategoria(1);

        /*
         f) Calcular el monto total recaudado por cada categoría
         y el total de toda la carrera incluyendo todas las categorías.
         */
        Map<Categoria, Double> recaudacionPorCategoria = new HashMap<>();

        for (Inscripcion inscripcion : inscripciones) {
            recaudacionPorCategoria.put(
                inscripcion.getCategoria(),
                recaudacionPorCategoria.getOrDefault(inscripcion.getCategoria(), 0.0) + inscripcion.getMontoInscripcion()
            );
        }

        System.out.println("\nRecaudación por categoría:");
        recaudacionPorCategoria.forEach((categoria, recaudacion) ->
            System.out.println("%s: $%.2f".formatted(categoria.getNombre(), recaudacion))
        );

        double recaudacionTotal = recaudacionPorCategoria.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("\nRecaudación total: $%.2f".formatted(recaudacionTotal));
    }


    private static void imprimirInscripcionesPorCategoria(int idCategoria) {

        Categoria categoria = categorias.stream().filter(c -> c.getId() == idCategoria).findFirst().orElseThrow();

        System.out.println("\nInscriptos en la categoría '%s':".formatted(categoria.getNombre()));

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria() == categoria) {
                System.out.println(
                    "%s %s - Inscripción Nº %d - DNI %s - Edad %d - Teléfono %s - Grupo sanguíneo %s - Monto a abonar $%.2f"
                        .formatted(
                            inscripcion.getParticipante().getNombre(),
                            inscripcion.getParticipante().getApellido(),
                            inscripcion.getNumeroInscripcion(),
                            inscripcion.getParticipante().getDni(),
                            inscripcion.getParticipante().getEdad(),
                            inscripcion.getParticipante().getTelefono(),
                            inscripcion.getParticipante().getGrupoSanguineo(),
                            inscripcion.getMontoInscripcion()
                        )
                );
            }
        }
    }

}
