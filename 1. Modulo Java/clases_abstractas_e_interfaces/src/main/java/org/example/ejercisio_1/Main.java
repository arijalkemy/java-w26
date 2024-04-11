package org.example.ejercisio_1;

import org.example.ejercisio_1.cliente.Basic;
import org.example.ejercisio_1.cliente.Cobrador;
import org.example.ejercisio_1.cliente.Ejecutivo;
import org.example.ejercisio_1.transaccion.Transaccion;

public class Main {
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        ejecutivo.realizarDeposito(2000, Transaccion.transaccionOk());
        basic.pagarServicio(Transaccion.transaccionNoOk());
        cobrador.retirarEfectivo(5000, Transaccion.transaccionOk());
    }
}
