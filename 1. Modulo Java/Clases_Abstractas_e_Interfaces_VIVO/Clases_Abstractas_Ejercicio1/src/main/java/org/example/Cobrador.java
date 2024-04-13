package org.example;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
    }

    public void retirarEfectivo(Double monto) {
        System.out.println("Intentando retirar: " + monto);
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se pudo concluir");
    }
}
