package meli.bootcamp.Banco;

import meli.bootcamp.Banco.entidades.Basic;
import meli.bootcamp.Banco.entidades.Cobrador;
import meli.bootcamp.Banco.entidades.Ejecutivo;

public class Banco {
    public static void main(String[] args) {
        Basic clienteBasic = new Basic();
        clienteBasic.consultarSaldo();
        System.out.println(clienteBasic.transaccionOk());

        Ejecutivo clienteEjecutivo = new Ejecutivo();
        clienteEjecutivo.depositar();
        System.out.println(clienteEjecutivo.transaccionOk());
        clienteEjecutivo.transferir();
        System.out.println(clienteEjecutivo.transaccionNoOk());

        Cobrador clienteCobrador = new Cobrador();
        clienteCobrador.retirarEfectivo();
        System.out.println(clienteCobrador.transaccionOk());
    }
}
