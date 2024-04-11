package meli.bootcamp.ejercicio1.transacciones.impl;

import meli.bootcamp.ejercicio1.transacciones.Transaccion;

public class PagarServicio implements Transaccion {
  @Override
  public void transaccionOk() {
    System.out.println("Pago de servicios realizado con éxito.");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("Error al realizar el pago de servicios.");
  }

  @Override
  public void realizar() {
    // Logica para determinar si la transaccion fue ok o no
    if (true) {
      transaccionOk();
    } else {
      transaccionNoOk();
    }
  }
}
