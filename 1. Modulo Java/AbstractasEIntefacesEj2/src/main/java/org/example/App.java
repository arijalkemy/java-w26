package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
    {
        public static void main(String[] args) {
            Curriculum cv = new Curriculum(new Persona("pepe", "perez", 30 ), Arrays.asList("c++", "java", "c#"));
            LibrosPDF harryPotter = new LibrosPDF(4000, "JK Rowling", "Harry Potter y la piedra filosofal", "Fantasia");

            Impresora.imprimir(cv);
            Impresora.imprimir(harryPotter);
        }
    }
