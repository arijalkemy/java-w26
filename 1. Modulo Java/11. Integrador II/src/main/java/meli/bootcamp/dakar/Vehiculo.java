package meli.bootcamp.dakar;

public class Vehiculo {
  private final String patente;
  private final double velocidad;
  private final double aceleracion;
  private final double anguloDeGiro;
  private final double peso;
  private final int ruedas;
  private String marca;
  private String modelo;

  public Vehiculo(
      double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas
  ) {
    this.velocidad = velocidad;
    this.aceleracion = aceleracion;
    this.anguloDeGiro = anguloDeGiro;
    this.patente = patente;
    this.peso = peso;
    this.ruedas = ruedas;
  }

  public String getPatente() {
    return patente;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public double getVelocidad() {
    return velocidad;
  }

  public double getAceleracion() {
    return aceleracion;
  }

  public double getAnguloDeGiro() {
    return anguloDeGiro;
  }

  public double getPeso() {
    return peso;
  }

  public int getRuedas() {
    return ruedas;
  }

  @Override
  public String toString() {
    return "Vehiculo{" +
        "patente = '" + patente + '\'' +
        ", marca = '" + marca + '\'' +
        ", modelo = '" + modelo + '\'' +
        ", velocidad = " + velocidad +
        ", aceleracion = " + aceleracion +
        ", anguloDeGiro = " + anguloDeGiro +
        ", peso = " + peso +
        ", ruedas = " + ruedas +
        '}';
  }

  public double calcularPuntaje() {
    return velocidad * 0.5 * aceleracion / (anguloDeGiro * (peso - ruedas * 100));
  }

}
