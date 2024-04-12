package org.example;

import java.util.ArrayList;

public class App
{
    public static <List> void main(String[] args )
    {
        Categorias categoriaChico = new Categorias("chico", "2 km por selva y arroyos", 2);
        Categorias categoriaMediana = new Categorias("mediana", "5 km por selva, arroyos y barro", 2);
        Categorias categoriaAvanzada = new Categorias("avanzada", "10 km por selva, arroyos, barro y escalada en piedra.", 2);

        Participante participante1 = new Participante(1, "pedro", "arriaga", 27, "qwertyu", "5555555555", "2222222222",  "o+");

        Participante participante2 = new Participante(2, "luis", "lopez", 27, "asdfghjk", "1111111111", "3333333333",  "o-");

        Participante participante3 = new Participante(3, "arturo", "hernandez", 27, "hgdsa", "6666666666", "8888888888",  "o");

        Inscripcion inscripcion1 = new Inscripcion(1, categoriaChico, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, categoriaMediana, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoriaAvanzada, participante3);


        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);

        System.out.println("Inscripciones:");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("---------------------------------");
            System.out.println("Nombre " + inscripcion.getParticipante().getNombre());
            System.out.println("apellido " + inscripcion.getParticipante().getApellidos());
            System.out.println("adad " + inscripcion.getParticipante().getEdad());
            System.out.println("Numero de inscripcion " + inscripcion.getParticipante().getId());
        }

        System.out.println("eliminacion de participantes");
        inscripciones.remove(inscripcion1);

        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("---------------------------------");
            System.out.println("Nombre " + inscripcion.getParticipante().getNombre());
            System.out.println("apellido " + inscripcion.getParticipante().getApellidos());
            System.out.println("adad " + inscripcion.getParticipante().getEdad());
            System.out.println("Numero de inscripcion " + inscripcion.getParticipante().getId());
        }


        int montoTotal = 0;
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("------------Monto Por categoria---------------------");
            System.out.println("participante: " + inscripcion.getParticipante().getNombre() + " Monto: " + inscripcion.montoInscripcion() + " Categoria: " + inscripcion.getCategoria().getNombre());
            montoTotal += inscripcion.montoInscripcion();
        }

        System.out.println("Monto Total: " + montoTotal);

    }
}
