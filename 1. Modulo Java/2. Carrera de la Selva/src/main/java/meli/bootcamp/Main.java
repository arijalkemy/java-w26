package meli.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Categoria circuitoChico = new Categoria(
        "Circuito Chico",
        "2KM por selva y arroyos",
        0,
        1300.0,
        1500.0,
        18
    );

    Categoria circuitoMedio = new Categoria(
        "Circuito Medio",
        "5KM por selva, arroyos y barro",
        0,
        2000.0,
        2300.0,
        18
    );

    Categoria circuitoAvanzado = new Categoria(
        "Circuito Avanzado",
        "10KM por selva, arroyos, barro y escañadas en piedra",
        18,
        2800.0,
        2800.0,
        18
    );

    Persona persona1 = new Persona(
        1,
        12345678,
        "Juan",
        "Perez",
        20,
        1122334455,
        1122334455,
        "A+"
    );

    Persona persona2 = new Persona(
        2,
        87654321,
        "Maria",
        "Gomez",
        17,
        1122334455,
        1122334455,
        "B+"
    );

    Persona persona3 = new Persona(
        3,
        12345678,
        "Juan",
        "Perez",
        20,
        1122334455,
        1122334455,
        "A+"
    );

    Persona persona4 = new Persona(
        4,
        87654321,
        "Maria",
        "Gomez",
        17,
        1122334455,
        1122334455,
        "B+"
    );

    circuitoChico.inscribir(persona1);
    circuitoChico.inscribir(persona2);
    circuitoMedio.inscribir(persona3);
    circuitoAvanzado.inscribir(persona4);

    circuitoChico.imprimirInscriptos();
    circuitoMedio.imprimirInscriptos();
    circuitoAvanzado.imprimirInscriptos();
  }
}