package org.example.ejercisio_1.cliente;

import org.example.ejercisio_1.transaccion.RealizarDeposito;
import org.example.ejercisio_1.transaccion.Transferencia;

public class Ejecutivo extends Cliente implements RealizarDeposito, Transferencia {
    public Ejecutivo() {
    }
}
