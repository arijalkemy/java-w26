package org.example;

public class Basic implements ConsultaSaldo, Retiro, PagoServicios {
    @Override
    public void consultarSaldo() {
        System.out.println("Consulta saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pago servicio");
    }

    @Override
    public void retirar() {
        System.out.println("Retirar");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion Ok "+ transaccion);
    }

    @Override
    public void transaccionNOk(String transaccion) {
        System.out.println("Transaccion NOk " + transaccion);
    }
}
