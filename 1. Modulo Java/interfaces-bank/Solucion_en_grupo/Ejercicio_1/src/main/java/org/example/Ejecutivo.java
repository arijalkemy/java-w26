package org.example;

public class Ejecutivo extends Cliente{

    public Ejecutivo(String nombre_apellido) {
        super(nombre_apellido);
    }

    @Override
    public void depositar(){
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    @Override
    public void transferir(){
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionNoOk();
    }

    public void consultar_saldo() {}

    public void pagar_servicio() {}

    public void retirar_efectivo() {}
}
