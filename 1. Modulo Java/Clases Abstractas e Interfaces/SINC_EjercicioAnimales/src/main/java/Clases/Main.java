package Clases;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println(perro.emitirSonido());
        System.out.println(perro.comerCarne());

        System.out.println(vaca.emitirSonido());
        System.out.println(vaca.comerHierba());

        System.out.println(gato.emitirSonido());
        System.out.println(gato.comerCarne());
    }
}
