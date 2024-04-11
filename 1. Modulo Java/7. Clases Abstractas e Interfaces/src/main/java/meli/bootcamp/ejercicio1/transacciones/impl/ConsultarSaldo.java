package meli.bootcamp.ejercicio1.transacciones.impl;

import meli.bootcamp.ejercicio1.transacciones.Transaccion;

public class ConsultarSaldo implements Transaccion {
  @Override
  public void transaccionOk() {
    System.out.println("Consulta de saldo realizada con éxito.");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("Error al realizar la consulta de saldo.");
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
