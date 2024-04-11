package meli.bootcamp;

public class Perecedero extends Producto {
  int diasPorCaducar;

  public Perecedero(String nombre, double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  public int getDiasPorCaducar() {
    return diasPorCaducar;
  }

  public void setDiasPorCaducar(int diasPorCaducar) {
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public String toString() {
    return "Perecedero {" +
        "diasPorCaducar = " + diasPorCaducar +
        '}';
  }

  @Override
  public double calcularPrecio(int cantidad) {
    return super.calcularPrecio(cantidad) / factorDeReduccion();
  }

  private double factorDeReduccion() {
    if(diasPorCaducar == 1)
      return 4;

    if(diasPorCaducar == 2)
      return 3;

    if(diasPorCaducar == 3)
      return 2;

    return 1;
  }
}
