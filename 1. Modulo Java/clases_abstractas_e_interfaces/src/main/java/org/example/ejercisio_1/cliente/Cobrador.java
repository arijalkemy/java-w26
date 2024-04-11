package org.example.ejercisio_1.cliente;

import org.example.ejercisio_1.transaccion.ConsultaDeSaldo;
import org.example.ejercisio_1.transaccion.RetiroDeEfectivo;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {
    public Cobrador() {
    }
}
