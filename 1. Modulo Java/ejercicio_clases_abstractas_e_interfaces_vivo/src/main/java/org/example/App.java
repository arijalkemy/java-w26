package org.example;

import org.example.ejercicio_2.Curriculum;
import org.example.ejercicio_2.Imprimible;
import org.example.ejercicio_2.Informe;
import org.example.ejercicio_2.LibroPDF;
import org.example.ejercicio_3.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // 2)
        List<String> habilidades = new ArrayList<String>() {{add("React"); add("Node.js");}};
        Curriculum cv = new Curriculum("Jane Doe", "jane@example.com", habilidades);
        LibroPDF libro = new LibroPDF(500, "Aldous Huxley", "Un Mundo Feliz", "Ciencia Ficción");
        Informe informe = new Informe(10, 25, "John Doe", "Jane Roe");

        Imprimible.imprimir(cv);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);

        // 3)
        List<Animal> animales = new ArrayList<Animal>() {{
            add(new Perro());
            add(new Gato());
            add(new Vaca());
        }};
        for(Animal animal : animales) {
            animal.emitirSonido();
            comerAnimal(animal);
        }

    }

    public static void comerAnimal(Animal animal) {
        if(animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        }
    }
}
