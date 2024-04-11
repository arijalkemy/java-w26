package org.example.AbstractClass_Interfaces;

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
