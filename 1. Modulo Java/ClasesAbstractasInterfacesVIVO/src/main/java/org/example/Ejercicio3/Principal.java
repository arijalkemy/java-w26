package org.example.Ejercicio3;

public class Principal {
    public static void main(String[] args) {
        Perro perro = new Perro("Firulais", "Macho", "Perro");
        perro.emitirSonido();
        perro.comerCarne();
        Gato gato = new Gato("Garfield", "Macho", "Gato");
        gato.emitirSonido();
        gato.comerCarne();
        Vaca vaca = new Vaca("Vaca", "Hembra", "Vaca");
        vaca.emitirSonido();
        vaca.comerHierba();
        Animal.comerAnimal(perro);
    }
}
