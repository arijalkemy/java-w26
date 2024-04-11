package org.example.AbstractClass_Interfaces;

import org.example.AbstractClass_Interfaces.Clients.Basic;
import org.example.AbstractClass_Interfaces.Clients.Cobrador;
import org.example.AbstractClass_Interfaces.Clients.Ejecutivo;

public class App {

    public static void main(String[] args) {
        Basic cuenta = new Basic();
        cuenta.pago();
        cuenta.consulta();
        cuenta.retiro();
        cuenta.transaccionOk();
        cuenta.transaccionNoOk();

        Cobrador cobrador = new Cobrador();
        cobrador.consulta();
        cobrador.retiro();
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.deposito();
        ejecutivo.transferencia();
        ejecutivo.transaccionOk();
        ejecutivo.transaccionNoOk();
    }
}
