package ej3;

public class MainAAI {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        TipoDeAlimentacionDeAnimal.comerAnimal(vaca);
        vaca.emitirSonido();
    }
}
