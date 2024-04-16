package org.example.Ejercicio1;

public class ConsultaDeSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta Exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puede consultar");
    }
}
