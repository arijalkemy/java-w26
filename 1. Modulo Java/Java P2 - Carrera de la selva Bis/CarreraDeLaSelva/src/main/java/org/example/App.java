package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Inscripcion> listaInscriptos = new ArrayList<Inscripcion>();

        // a) Crear 3 objetos tipo categoria
        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.", 0, 1300, 1500);
        Categoria medio = new Categoria(1, "Circuito medio", "5 km por selva, arroyos y barro.", 0, 2000, 2300);
        Categoria avanzado = new Categoria(1, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 18, 2800, 2800);

        // b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar
        Participante participanteUno = new Participante(1, 40000000, "Lautaro", "Oleastro", 26, 215454545, 221544545, "0+");
        Inscripcion inscripcion = new Inscripcion(1, chico, participanteUno);
        listaInscriptos.add(inscripcion);
        // inscripcion.calcularCosto()

        // c) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        Participante participanteDos = new Participante(2, 30000000, "Lautaro", "Oleastro", 26, 215454545, 221544545, "0+");
        Participante participanteTres = new Participante(3, 50000000, "Lautaro", "Oleastro", 26, 215454545, 221544545, "0+");
        Inscripcion inscripcionDos = new Inscripcion(2, medio, participanteDos);
        Inscripcion inscripcionTres = new Inscripcion(3, chico, participanteTres);
        listaInscriptos.add(inscripcionDos);
        listaInscriptos.add(inscripcionTres);

        // d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        for (Inscripcion i : listaInscriptos) {
            if (i.getCategoria().equals(medio)) {
                System.out.println(i.getParticipante().toString());
                System.out.println("Numero de inscripcion: " + i.getNumero());
            }
        }

        // e) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        listaInscriptos.removeIf( i -> i.getParticipante().equals(participanteTres));
        for (Inscripcion i : listaInscriptos) {
            if (i.getCategoria().equals(chico)) {
                System.out.println(i.getParticipante().toString());
                System.out.println("Numero de inscripcion: " + i.getNumero());
            }
        }

        // f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        System.out.println("Recaudacion total: " + recaudacionTotal(listaInscriptos));

    }

    public static double recaudacionTotal(List<Inscripcion> listaDeInscriptos) {
        return listaDeInscriptos
                .stream()
                .mapToDouble(Inscripcion::getPrecio)
                .sum();
    }

    public static double recaudacionCategoria(List<Inscripcion> listaInscriptos, Categoria categoria) {
        return listaInscriptos
                .stream()
                .filter(inscripcion->inscripcion.getCategoria().equals(categoria))
                .mapToDouble(Inscripcion::getPrecio)
                .sum();
    }
}
