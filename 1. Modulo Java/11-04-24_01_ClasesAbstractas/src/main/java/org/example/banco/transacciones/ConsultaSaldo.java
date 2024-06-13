package org.example.banco.transacciones;
import org.example.banco.Transaccion;


public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo fallida");
    }
}
