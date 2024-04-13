package org.example;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {

    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
    }

    public void pagarServicio(String tipoServ) {
        System.out.println("Pagando servicio: " + tipoServ);

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
