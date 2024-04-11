package Ejercicio3;

public class Ej3 {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.hacerSonido();
        gato.hacerSonido();
        vaca.hacerSonido();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        perro.comerAnimal();
        gato.comerAnimal();
        vaca.comerAnimal();
    }
}
