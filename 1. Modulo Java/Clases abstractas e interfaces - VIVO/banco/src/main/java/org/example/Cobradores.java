package org.example;

public class Cobradores implements TransaccionesComunes, ResultadoTransaccion{
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
