package Clases;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Marcos", "Ditta", 42052682, "marcos.ditta@mercadolibre.com", List.of("Creativo", "Analitico", "Proactivo"));
        System.out.print(cv.imprimirDocumento());

        LibrosPdf libro = new LibrosPdf(143, "Marie Lu", "Warcross", "Ciencia Ficcion");
        System.out.print("\n" + libro.imprimirDocumento());

        Informe informe = new Informe(4352, 19, "Ignacio Granthon", "Bautista Granthon");
        System.out.print("\n" + informe.imprimirDocumento());
    }
}
