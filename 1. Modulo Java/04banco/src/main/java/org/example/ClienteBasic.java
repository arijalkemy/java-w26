package org.example;

public class ClienteBasic extends ClienteNormal {
    public void pagarServicios(ITransaccion transaccion) {
        System.out.println("Cliente Basic pagando servicios");
        transaccion.transaccionOk();
    }
}

