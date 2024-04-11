package org.example;

public class Main {
    public static void main(String[] args) {
        ClienteCobrador clienteCobrador = new ClienteCobrador();
        clienteCobrador.retirarEfectivo(new RetiroDeEfectivo());
        clienteCobrador.consultarSaldo(new ConsultaDeSaldo());

        ClienteBasic clienteBasic = new ClienteBasic();
        clienteBasic.retirarEfectivo(new RetiroDeEfectivo());
        clienteBasic.consultarSaldo(new ConsultaDeSaldo());
        clienteBasic.pagarServicios(new PagoDeServicios());

        ClienteEjecutivo clienteEjecutivo = new ClienteEjecutivo();
        clienteEjecutivo.depositar(new Deposito());
        clienteEjecutivo.transferir(new Transferencia());
    }
}


