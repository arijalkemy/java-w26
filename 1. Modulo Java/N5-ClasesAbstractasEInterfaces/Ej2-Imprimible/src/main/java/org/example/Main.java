package org.example;

import org.example.model.Curriculum;
import org.example.model.IImprimible;
import org.example.model.Informe;
import org.example.model.LibroPDF;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan Perez", 2, "Programación, Diseño UX/UI");
        LibroPDF libroPDF = new LibroPDF("El principito", 100, "Antoine de Saint-Exupéry", "Ficción");
        Informe informe = new Informe("Análisis financiero del primer trimestre", 5, "María Martinez", "Carlos Lopez");

        // Hago uso del método estático para obtener cada uno de los documentos
        System.out.println("-----Curriculum-----");
        IImprimible.imprimir(curriculum);
        System.out.println("-----Libro en PDF-----");
        IImprimible.imprimir(libroPDF);
        System.out.println("-----Informe-----");
        IImprimible.imprimir(informe);
    }
}