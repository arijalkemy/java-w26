package org.example.ejercicio_banco;

import org.example.ejercicio_banco.model.*;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println("      Transacciones del Ejecutivo        ");
        System.out.println(ejecutivo.hacerDepositoOk(new Deposito()));
        System.out.println(ejecutivo.hacerDepositoNoOk(new Deposito()));
        System.out.println(ejecutivo.hacerTransferenciaOk(new Transferencia()));
        System.out.println(ejecutivo.hacerTransferenciaNoOk(new Transferencia()));
        System.out.println("      Transacciones del Basic       ");
        System.out.println(basic.hacerConsultaSaldoOk(new ConsultaSaldo()));
        System.out.println(basic.hacerConsultaSaldoNoOk(new ConsultaSaldo()));
        System.out.println(basic.hacerPagoServicioOk(new PagoServicio()));
        System.out.println(basic.hacerPagoServicioNoOk(new PagoServicio()));
        System.out.println(basic.hacerRetiroEfectivoOk(new RetiroEfectivo()));
        System.out.println(basic.hacerRetiroEfectivoNoOk(new RetiroEfectivo()));
        System.out.println("      Transacciones del Cobrador       ");
        System.out.println(cobrador.hacerConsultaSaldoOk(new ConsultaSaldo()));
        System.out.println(cobrador.hacerConsultaSaldoNoOk(new ConsultaSaldo()));
        System.out.println(cobrador.hacerRetiroEfectivoOk(new RetiroEfectivo()));
        System.out.println(cobrador.hacerRetiroEfectivoNoOk(new RetiroEfectivo()));

    }
}