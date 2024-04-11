package meli.bootcamp.ejercicio1.clientes;

import meli.bootcamp.ejercicio1.transacciones.Transaccion;

import java.util.List;

public abstract class Cliente {
  List<Transaccion> transaccionesPermitidas;

  protected Cliente(List<Transaccion> transaccionesPermitidas) {
    this.transaccionesPermitidas = transaccionesPermitidas;
  }

  public List<Transaccion> getTransaccionesPermitidas() {
    return transaccionesPermitidas;
  }

  public void realizarTransaccion(Transaccion transaccion) {
    if (!transaccionesPermitidas.contains(transaccion))
      throw new IllegalArgumentException("Transacción no permitida");

    transaccion.realizar();
  }
}
