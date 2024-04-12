package ex1;

import interfaces.ITransaccion;

public class Basic implements ITransaccion {

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
    public void consultarSaldo(){
        System.out.println("Consultando saldo");
    }
    public void pagarServicio(){
        System.out.println("Pagando servicio");
    }
    public void retiroDeEfectivo(){
        System.out.println("Retirando efectivo");
    }
}
