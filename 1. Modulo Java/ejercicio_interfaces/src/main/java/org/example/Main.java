package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("<---- Ejercicio 1 ---->");
        Basic personBasic = new Basic(2.99);
        personBasic.consultaDeSaldo();
        personBasic.transactionOk();

        personBasic.retiroEfectivo(1.99);

        Cobrador cobrador = new Cobrador(4.99);
        cobrador.consultaDeSaldo();

        System.out.println("");

        System.out.println("<---- Ejercicio 2 ---->");
        Curriculum cv = new Curriculum("Persona1", 20, Arrays.asList("Suerte","Fuerte"));
        Pdf pdf = new Pdf(100, "Persona 2", "Titulo1", "Terror");
        Informe informe = new Informe("Autor 1", "Revisor 1", 120,"aovnaorifnodanvoá");

        Documentos.imprimeDocumento(cv);
        Documentos.imprimeDocumento(pdf);
        System.out.println("");
        Documentos.imprimeDocumento(informe);
        System.out.println("");
        System.out.println("<---- Ejercicio 3 ---->");
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        Comida.comerAnimal(perro);
        Comida.comerAnimal(gato);
        Comida.comerAnimal(vaca);
    }
}
