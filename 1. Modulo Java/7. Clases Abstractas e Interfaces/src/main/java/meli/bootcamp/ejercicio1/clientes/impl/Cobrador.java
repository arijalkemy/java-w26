package meli.bootcamp.ejercicio1.clientes.impl;

import meli.bootcamp.ejercicio1.clientes.Cliente;
import meli.bootcamp.ejercicio1.transacciones.impl.ConsultarSaldo;
import meli.bootcamp.ejercicio1.transacciones.impl.RetirarEfectivo;

import java.util.List;

public class Cobrador extends Cliente {
  public Cobrador() {
    super(List.of(new RetirarEfectivo(), new ConsultarSaldo()));
  }
}
