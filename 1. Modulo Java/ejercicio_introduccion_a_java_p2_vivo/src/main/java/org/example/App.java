package org.example;

import org.example.classes.Carrera;
import org.example.classes.Categoria;
import org.example.classes.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main( String[] args ) {
        Random random = new Random();
        Carrera carrera = new Carrera("Carrera de la Selva");

        // a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10km por selva, arroyos, barro y escalada en piedra", 18);

        // b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar
        Participante participanteUno = new Participante(1, "30000001", "Sergio", "Romero", 16, "+5492664001122", "+5492664001122", "0");
        carrera.inscribirParticipante(1, participanteUno, circuitoChico);

        // c) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        carrera.inscribirParticipante(2, new Participante(2, "30000002", "Leandro", "Brey", 20, "+5492664001122", "+5492664001122", "0"), circuitoMedio);
        carrera.inscribirParticipante(3, new Participante(3, "30000003", "Marcos", "Rojo", 27, "+5492664001122", "+5492664001122", "0"), circuitoAvanzado);

        List<Participante> participantes = new ArrayList<Participante>() {{
            add(new Participante(4, "30000004", "Luis", "Advincula", 15, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(5, "30000005", "Marcelo", "Saracchi", 24, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(6, "30000006", "Lucas", "Blondel", 24, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(7, "30000007", "Kevin", "Zenon", 21, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(8, "30000008", "Lautaro", "Blanco", 28, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(9, "30000005", "Nicolas", "Valentini", 23, "+5492664001122", "+5492664001122", "0"));
            add(new Participante(10, "30000010", "Jabes", "Saralegui", 16, "+5492664001122", "+5492664001122", "0"));
        }};

        for(int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(3) + 1;
            switch (randomNumber){
                case 1:
                    carrera.inscribirParticipante(i+2, participantes.get(i), circuitoChico);
                    break;
                case 2:
                    carrera.inscribirParticipante(i+2, participantes.get(i), circuitoMedio);
                    break;
                case 3:
                    carrera.inscribirParticipante(i+2, participantes.get(i), circuitoAvanzado);
                    break;
            }
        }

        // d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        carrera.mostrarParticipantesDeCategoria(circuitoChico);
        System.out.println("\n");
        carrera.mostrarParticipantesDeCategoria(circuitoMedio);
        System.out.println("\n");
        carrera.mostrarParticipantesDeCategoria(circuitoAvanzado);
        System.out.println("\n");

        // e) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        carrera.desinscribirParticipante(participanteUno);
        System.out.println("La lista de inscriptos de la categoría " + circuitoChico.getNombre() + " queda de la siguiente manera luego de la desinscripción del participante:");
        carrera.mostrarParticipantesDeCategoria(circuitoChico);
        System.out.println("\n");

        // f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        System.out.println("El monto total recaudado por la categoria " + circuitoChico.getNombre() + " es: $" + String.valueOf(carrera.getMontoRecaudadoPorCategoria(circuitoChico)));
        System.out.println("El monto total recaudado por la categoria " + circuitoMedio.getNombre() + " es: $" + String.valueOf(carrera.getMontoRecaudadoPorCategoria(circuitoMedio)));
        System.out.println("El monto total recaudado por la categoria " + circuitoAvanzado.getNombre() + " es: $" + String.valueOf(carrera.getMontoRecaudadoPorCategoria(circuitoAvanzado)));
        System.out.println("El monto total recaudado de la carrera es: $" + String.valueOf(carrera.getMontoTotalRecaudado()));
    }
}
