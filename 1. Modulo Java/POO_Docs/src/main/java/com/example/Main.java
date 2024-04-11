package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilitades = new ArrayList<>();
        habilitades.add("JAVA");
        Imprimible cv = new Curriculum("Ignacio", "Perez", 512, "123abc", habilitades);
        cv.imprimir();

        Imprimible libroPDF = new LibrosEnPDF(5, "Lovecraft", "La llamada de Cthulhu ", "Terror");
        libroPDF.imprimir();

        //Texto generado con Lorem Ipsum
        String texto = "Lorem ipsum dolor sit amet consectetur adipiscing elit blandit, tempor porttitor ad platea posuere proin eleifend ullamcorper aenean, ut neque est risus nulla natoque fringilla. Class tristique convallis magna sodales mattis tincidunt nulla fermentum consequat, orci fringilla dui auctor phasellus interdum aenean laoreet, conubia ultricies ut augue sociosqu nisl habitasse inceptos. Vehicula lacus donec suspendisse vulputate porta congue quam ante platea fermentum id, urna egestas cubilia justo at fames ridiculus rutrum imperdiet penatibus.";
        Imprimible informe = new Informe(texto, 500, "Einstein", "Aristoteles");
        informe.imprimir();
    }
}