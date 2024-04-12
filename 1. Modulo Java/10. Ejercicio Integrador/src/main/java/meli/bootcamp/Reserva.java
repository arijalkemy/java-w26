package meli.bootcamp;

public class Reserva {
  TipoReserva tipoReserva;
  double precio;
  double descuento;

  public Reserva(TipoReserva tipoReserva, double precio) {
    this.tipoReserva = tipoReserva;
    this.precio = precio;
    this.descuento = 0;
  }

  public void setDescuento(double descuentoEnPorcentaje) {
    this.descuento *= descuentoEnPorcentaje;
  }

  public double getPrecioFinal() {
    return this.precio - this.descuento;
  }

  public double getPrecio() {
    return precio;
  }

  public double getDescuento() {
    return descuento;
  }

  public TipoReserva getTipoReserva() {
    return tipoReserva;
  }
}
