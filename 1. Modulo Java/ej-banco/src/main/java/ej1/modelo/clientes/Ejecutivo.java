package ej1.modelo.clientes;

import ej1.modelo.transacciones.Deposito;
import ej1.modelo.transacciones.Transferencia;

import java.util.List;

public class Ejecutivo extends TipoDeCliente {
    public Ejecutivo(){
        super(List.of(new Deposito(), new Transferencia()));
    }
}
