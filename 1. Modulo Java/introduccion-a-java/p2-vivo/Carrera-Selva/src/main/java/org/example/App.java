package org.example;

import java.util.ArrayList;

public class App
{

    public static void main( String[] args )
    {
        Categoria avanzado = new Categoria("Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", 0, 2800);
        Categoria medio = new Categoria("Medio", "5 km por selva, arroyos y barro.", 2000, 2300);
        Categoria chico = new Categoria("Chico", "2 km por selva y arroyos.", 1300, 1500);

        Inscripciones competencia = new Inscripciones();

        Competidor competidor1 = new Competidor(1, "Jose", "Perez", "178232183", 33, "1122334455", "1122334455", "A+");

        competencia.inscribir(1, avanzado, competidor1);
        System.out.println("Monto a abonar: $" + competencia.getMontoAbonar(1));

        competencia.inscribir(
                2,
                medio,
                new Competidor(2, "Roberto", "Flores", "178232183", 15, "1122334455", "1122334455", "A+")
        );

        competencia.inscribir(
                3,
                chico,
                new Competidor(3, "Maria", "Gomez", "178232183", 25, "1122334455", "1122334455", "A+")
        );

        competencia.verListaDeInscriptos();
        competencia.calcularRecaudacion();

        competencia.desinscribir(1);

        competencia.verListaDeInscriptos();
        competencia.calcularRecaudacion();

    }
}
