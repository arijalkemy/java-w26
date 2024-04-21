package org.example;

import org.example.interfaces.IConsultaDeSaldo;
import org.example.interfaces.IRetiroDeEfectivo;

public class Cobrador implements IRetiroDeEfectivo, IConsultaDeSaldo {


    @Override
    public void consultarSaldo() {
        System.out.println("consultando saldo");
        transaccionNoOk("consulta de saldo");
    }

    @Override
    public void retirarEfectivo(int monto) {
        System.out.println("retirando: " + monto );
        transaccionOk("retiro de efectivo");
    }

    @Override
    public void transaccionOk(String tipoDeTransaccion) {
        System.out.println("cliente: Cobrador, transaccion " + tipoDeTransaccion + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoDeTransaccion) {
        System.out.println("cliente: Cobrador, transaccion " + tipoDeTransaccion + " no se pudo realizar");
    }
}
