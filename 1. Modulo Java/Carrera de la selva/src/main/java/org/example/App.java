package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Declaro e inicializo la lista de inscripciones
        List<Inscripcion> inscripciones = new ArrayList<>();

        //Creo array de nombres aleatorios
        String[] nombres = {"Franco", "Pedro", "Juan", "Agus", "Cande", "Flor", "Ori" };
        //Idem con apellidos
        String[] apellidos = {"Suarez", "Moises", "Rodriguez", "Lopez", "Garcia", "Tolosa", "Carraro" };
        //Idem con grupos sanguineos
        String[] gruposSanguineos = {"A+", "A-", "B+", "B-" };

        //Creo las categorias (actividad A) y las guardo en una lista para luego poder elegir aleatoriamente
        Categoria circuitoChico = new Categoria(1, "Circuito chico",
                "2km, por selva y arroyos", 1300, 1500);
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5km, por selvas, " +
                "arroyos y barro", 2000, 2300);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10km, por selva, " +
                "arroyos, barro y escalada de piedra", -1, 2800);
        List<Categoria> categorias = new ArrayList<>(List.of(circuitoChico, circuitoMedio, circuitoAvanzado));


        //Declaro e instancio el participante (actividad B)
        Participante participante = new Participante(1, "44195957", "Franco",
                "Moises", 21, "3518034940", "3518034940", "B+");

        //Creo la inscripcion y la agrego a la lista si esta permitido segun edad y categoría
        Inscripcion inscripcion = new Inscripcion(1, circuitoAvanzado, participante, circuitoAvanzado.obtenerMonto(participante.getEdad()));
        if (inscripcion.getMontoPagado() < 0) {
            System.out.println("No se puede inscribir a un menor de edad al circuito avanzado");
        } else {
            inscripciones.add(inscripcion);
        }

        Random rnd = new Random();
        //Creo e inscribo 10 participantes con datos aleatorios (actividad C)
        for (int i = 0; i < 10; i++) {

            //Genero datos aleatorios y creo participante
            String nom = nombres[ThreadLocalRandom.current().nextInt(0, nombres.length)];
            String ape = apellidos[ThreadLocalRandom.current().nextInt(0, apellidos.length)];
            String dni = String.valueOf(ThreadLocalRandom.current().nextInt(20000000, 50000000));
            int edad = ThreadLocalRandom.current().nextInt(13, 71);
            String celular = "351" + String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999));
            String grupoSanguineo = gruposSanguineos[ThreadLocalRandom.current().nextInt(0, gruposSanguineos.length)];
            String numEmergencia = "351" + String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999));
            Participante p = new Participante(i + 2, dni, nom, ape, edad, celular, numEmergencia, grupoSanguineo);

            // Elijo categoria aleatoria e inscribo al participante si corresponde.
            Categoria cat = categorias.get(ThreadLocalRandom.current().nextInt(0, categorias.size()));
            Inscripcion ins = new Inscripcion(inscripciones.size(), cat, p, cat.obtenerMonto(p.getEdad()));
            if (ins.getMontoPagado() < 0) {
                System.out.println("No se puede inscribir a un menor de edad al circuito avanzado");
            } else {
                inscripciones.add(ins);
            }
        }
        //Muestro datos de inscriptos a una categoría (actividad D)
        int indiceCategoriaRandom = ThreadLocalRandom.current().nextInt(0, categorias.size());
        mostrarInscripcionesPorCategoria(inscripciones,categorias.get(indiceCategoriaRandom));


        //Desinscribo un participante random y muestro la lista de esa categoría
        int indiceParticipanteRandom = ThreadLocalRandom.current().nextInt(0, inscripciones.size());
        Inscripcion inscripcionRemovida = inscripciones.get(indiceParticipanteRandom);
        inscripciones.remove(indiceParticipanteRandom);
        mostrarInscripcionesPorCategoria(inscripciones,inscripcionRemovida.getCategoria());
        

    }

    //Metodo para mostrar las inscripciones y datos de cada participante
    //en una determinada categoria
    public static void mostrarInscripcionesPorCategoria(List<Inscripcion> inscripciones, Categoria categoria) {
        System.out.println("Inscripciones de " + categoria.getNombre() + ": \n");
        for (Inscripcion i : inscripciones) {
            if (i.getCategoria() == categoria) {
                Participante participanteCat = i.getParticipante();
                System.out.println("Inscripcion Nro: " + i.getNro());
                System.out.println("Nombre: " + participanteCat.getNombre() + " "
                        + participanteCat.getApellido() );
                System.out.println("DNI: " + participanteCat.getDni());
                System.out.println("Edad: " + participanteCat.getEdad());
                System.out.println("Celular: " + participanteCat.getCelular());
                System.out.println("Grupo Sanguineo: " + participanteCat.getGrupoSanguineo() + "\n");


            }
        }
    }
}
