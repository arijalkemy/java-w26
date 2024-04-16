package org.example.Ejercicio1;

public class Banco {
    public static void main(String[] args) {

        //para ejecutarlo creo los clientes y realizo algunas transferencias en el banco

        Cliente ejecutivo = new Ejecutivo();
        Cliente basic = new Basic();
        Cliente cobrador = new Cobradores();

        //creo las transferencias para los clientes
        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Tranferencia();
        Transaccion retiroEfectivo = new RetiroDeEfectivo();
        Transaccion consultaSaldo = new ConsultaDeSaldo();
        Transaccion pagoServicio = new PagoDeServicio();

        //clientes realizando las tranferencias
        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(transferencia);

        basic.realizarTransaccion(consultaSaldo);
        basic.realizarTransaccion(pagoServicio);

        cobrador.realizarTransaccion(retiroEfectivo);
        cobrador.realizarTransaccion(consultaSaldo);
    }
}