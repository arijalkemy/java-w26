package meli.bootcamp.ejercicio3;

public class Ejercicio3 {
  public static void main(String[] args) {
    Gato  gato = new Gato();
    Perro perro = new Perro();
    Vaca  vaca = new Vaca();

    gato.emitirSonido();
    gato.comerCarne();

    perro.emitirSonido();
    perro.comerCarne();

    vaca.emitirSonido();
    vaca.comerHierba();
    }
}
