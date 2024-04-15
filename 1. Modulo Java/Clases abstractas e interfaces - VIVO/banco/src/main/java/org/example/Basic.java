package org.example;

public class Basic implements TransaccionesComunes, TransaccionesBasic , ResultadoTransaccion{
    @Override
    public void pagoServicios() {
        System.out.println("realizando pago de servicio");
        try {
            transaccionOk();
        } catch (Exception e) {
            transaccionNoOk();
        }
    }

    @Override
    public void consultarSaldo() {
        System.out.println("realizando consulta de saldo");
        try {
            transaccionOk();
        } catch (Exception e) {
            transaccionNoOk();
        }
    }

    @Override
    public void retirarDinero() {
        System.out.println("realizando retiro de dinero");
        try {
            transaccionOk();
        } catch (Exception e) {
            transaccionNoOk();
        }
    }
}
