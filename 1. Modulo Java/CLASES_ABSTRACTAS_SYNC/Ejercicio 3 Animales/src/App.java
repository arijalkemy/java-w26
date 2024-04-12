import Animales.Gato;
import Animales.Perro;
import Animales.Vaca;
import IAnimales.AccionesAnimales;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Gato gato = new Gato();
        gato.emitirSonido();

        Perro perro = new Perro();
        perro.emitirSonido();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();

        AccionesAnimales.hacerComer(vaca);
        AccionesAnimales.hacerComer(perro);
        AccionesAnimales.hacerComer(gato);
    }
}
