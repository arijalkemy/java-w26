package meli.bootcamp.dakar;

public class SocorristaAuto extends Vehiculo {

  public SocorristaAuto(
      double velocidad, double aceleracion, double anguloDeGiro,
      String patente, int peso, int ruedas
  ) {
    super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
  }

  public void socorrer(Vehiculo auto) {
    System.out.println("Socorriendo auto " + auto.getPatente());
  }
}
