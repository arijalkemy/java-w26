package meli.bootcamp;

public class Vehiculo {
  String marca;
  String modelo;
  int costo;

  public Vehiculo(String marca, String modelo, int costo) {
    this.marca = marca;
    this.modelo = modelo;
    this.costo = costo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getCosto() {
    return costo;
  }

  public void setCosto(int costo) {
    this.costo = costo;
  }

  public int compararPorMarcaYprecio(Vehiculo vehiculo) {
    // Cuando son iguales se ordena por precio
    if (this.marca.equals(vehiculo.marca)) {
      return this.costo - vehiculo.costo;
    }

    // Devuelve un numero positivo si this.marca es mayor que vehiculo.marca
    // Devuelve un numero negativo si this.marca es menor que vehiculo.marca
    // Devuelve 0 si this.marca es igual a vehiculo.marca
    return this.marca.compareTo(vehiculo.marca);
  }

  @Override
  public String toString() {
    return "Vehiculo { " +
        "marca = '" + marca + '\'' +
        ", modelo = '" + modelo + '\'' +
        ", costo = " + costo +
        '}';
  }
}
