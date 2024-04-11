package org.example.ejercisio_1.cliente;

import org.example.ejercisio_1.transaccion.ConsultaDeSaldo;
import org.example.ejercisio_1.transaccion.PagarServicio;
import org.example.ejercisio_1.transaccion.RetiroDeEfectivo;

public class Basic extends Cliente implements ConsultaDeSaldo, PagarServicio, RetiroDeEfectivo {
    public Basic() {
    }
}
