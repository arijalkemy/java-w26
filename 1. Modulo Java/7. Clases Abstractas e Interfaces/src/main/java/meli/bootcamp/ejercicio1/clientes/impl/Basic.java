package meli.bootcamp.ejercicio1.clientes.impl;

import meli.bootcamp.ejercicio1.clientes.Cliente;
import meli.bootcamp.ejercicio1.transacciones.impl.ConsultarSaldo;
import meli.bootcamp.ejercicio1.transacciones.impl.PagarServicio;
import meli.bootcamp.ejercicio1.transacciones.impl.RetirarEfectivo;

import java.util.List;

public class Basic extends Cliente {
  Basic() {
    super(List.of(new ConsultarSaldo(), new PagarServicio(), new RetirarEfectivo()));
  }
}
