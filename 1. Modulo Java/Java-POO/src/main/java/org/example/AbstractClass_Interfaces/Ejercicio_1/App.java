package org.example.AbstractClass_Interfaces.Ejercicio_1;

import org.example.AbstractClass_Interfaces.Ejercicio_1.Clients.Basic;
import org.example.AbstractClass_Interfaces.Ejercicio_1.Clients.Cobrador;
import org.example.AbstractClass_Interfaces.Ejercicio_1.Clients.Ejecutivo;

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
