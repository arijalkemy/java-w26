package meli.bootcamp.ejercicio1.clientes.impl;

import meli.bootcamp.ejercicio1.clientes.Cliente;
import meli.bootcamp.ejercicio1.transacciones.impl.Depositar;
import meli.bootcamp.ejercicio1.transacciones.impl.Transferir;

import java.util.List;

public class Ejecutivo extends Cliente {
  public Ejecutivo() {
    super(List.of(new Depositar(), new Transferir()));
  }
}
