package org.example;

import org.example.ejercicio1.cliente.Basic;
import org.example.ejercicio1.cliente.Cobrador;
import org.example.ejercicio1.cliente.Ejecutivo;
import org.example.ejercicio2.Curriculum;
import org.example.ejercicio2.Informe;
import org.example.ejercicio2.LibroPDF;
import org.example.ejercicio2.Impresora;
import org.example.ejercicio3.Animal;
import org.example.ejercicio3.Gato;
import org.example.ejercicio3.Perro;
import org.example.ejercicio3.Vaca;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // Ejercicio 1
        Basic basic = new Basic();
        basic.realizarConsultaDeSaldo();
        basic.realizarDeposito();

        Cobrador cobrador = new Cobrador();
        cobrador.realizarConsultaDeSaldo();
        cobrador.realizarDeposito();

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarConsultaDeSaldo();
        ejecutivo.realizarDeposito();

        // Ejercicio 2

        Impresora impresora = new Impresora();
        LibroPDF libroPDF = new LibroPDF(100, "Claudia Piñeiro", "Elena sabe", "Novela");
        Informe informe = new Informe("Informe social de salud", 10, "Ana Lopez", "Jose Korn");
        Curriculum curriculum = new Curriculum("Camila Beczkowski", "camila.beczkowski@mercadolibre.com", 28, "39459678", new ArrayList<>());

        curriculum.agregarHabilidad("Java");

        impresora.imprimir(libroPDF);
        impresora.imprimir(curriculum);
        impresora.imprimir(informe);

        // Ejercicio 3

        Animal perro = new Perro();
        Animal vaca = new Vaca();
        Animal gato = new Gato();

        // Cada animal hablando
        perro.emitirSonido();
        vaca.emitirSonido();
        gato.emitirSonido();

        // Cada animal comiendo
        // Lo puedo llamar con le metodo comer() o si se que es herviboro o carnivoro directamente del comer que le corresponde
        perro.comer();

        vaca.comer();
        gato.comer();

        // Cada animal comiendo pasandole por parametro un animal al metodo comerAnimal(Animal animal)
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);


    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }
}
