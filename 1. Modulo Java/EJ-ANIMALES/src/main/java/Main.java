import modelo.alimentador.Alimentador;
import modelo.animales.Gato;
import modelo.animales.Perro;
import modelo.animales.Vaca;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        Alimentador.alimentarAnimal(gato);
        System.out.println();

        Alimentador.alimentarAnimal(perro);
        System.out.println();

        Alimentador.alimentarAnimal(vaca);

    }
}
