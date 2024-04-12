package ej1;

import ej1.modelo.banco.Banco;
import ej1.modelo.clientes.Basic;
import ej1.modelo.clientes.Cliente;
import ej1.modelo.clientes.Cobradores;
import ej1.modelo.clientes.Ejecutivo;
import ej1.modelo.transacciones.*;

import java.nio.channels.CancelledKeyException;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        PagoDeServicios pagoDeServicios = new PagoDeServicios();
        ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
        RetiroDeEfectivo retiroDeEfectivo = new RetiroDeEfectivo();

        Cliente ejecutivo =  new Cliente(new Ejecutivo());
        Cliente basic = new Cliente(new Basic());
        Cliente cobrador = new Cliente(new Cobradores());

        System.out.println("EJECUTIVO:");

        System.out.println("Ejecutivo relizando deposito");
        banco.aplicarTransaccion(deposito,ejecutivo);
        System.out.println();

        System.out.println("Ejecutivo relizando transferencia");
        banco.aplicarTransaccion(transferencia,ejecutivo);
        System.out.println();

        System.out.println("BASIC:");

        System.out.println("Basic relizando consulta de saldo");
        banco.aplicarTransaccion(consultaDeSaldo,basic);
        System.out.println();

        System.out.println("Basic relizando pago de servicios");
        banco.aplicarTransaccion(pagoDeServicios,basic);
        System.out.println();

        System.out.println("Basic relizando retiro de efectivo");
        banco.aplicarTransaccion(retiroDeEfectivo,basic);
        System.out.println();

        System.out.println("COBRADOR: ");

        System.out.println("Cobradores relizando retiro de efectivo");
        banco.aplicarTransaccion(retiroDeEfectivo,cobrador);
        System.out.println();

        System.out.println("Cobradores relizando consulta de saldo");
        banco.aplicarTransaccion(consultaDeSaldo,cobrador);
        System.out.println();

        System.out.println("Cobrador realizando deposito (ellos no tienen permitido esto:");
        banco.aplicarTransaccion(deposito,cobrador);
    }
}
