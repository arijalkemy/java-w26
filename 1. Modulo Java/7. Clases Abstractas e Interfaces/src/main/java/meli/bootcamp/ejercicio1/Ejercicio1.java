package meli.bootcamp.ejercicio1;

import meli.bootcamp.ejercicio1.clientes.impl.Cobrador;
import meli.bootcamp.ejercicio1.transacciones.Transaccion;

import java.util.List;

public class Ejercicio1 {
  public static void main(String[] args) {
    Cobrador cobrador = new Cobrador();

    List<Transaccion> transacciones = cobrador.getTransaccionesPermitidas();

    cobrador.realizarTransaccion(transacciones.get(0));
  }
}