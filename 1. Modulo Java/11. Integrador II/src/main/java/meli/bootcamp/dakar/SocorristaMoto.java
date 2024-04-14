package meli.bootcamp.dakar;

public class SocorristaMoto extends Vehiculo {

  public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
    super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
  }

  public void socorrer(Moto moto) {
    System.out.println("Socorriendo moto " + moto.getPatente());
  }
}
