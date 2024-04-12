package org.main;

import org.ejerciciouno.entities.clientes.Basic;
import org.ejerciciouno.entities.clientes.Cobrador;
import org.ejerciciouno.entities.clientes.Ejecutivo;
import org.ejerciciouno.entities.financieros.*;
import org.ejerciciouno.interfaces.ITransaccion;

/**
 * Hello world!
 */
public class MainEjercicioUno {
    public static void main(String[] args) {
        ITransaccion deposito = new Deposito();
        ITransaccion consultaDeSaldo = new ConsultaDeSaldo();
        ITransaccion pagoDeServicios = new PagoDeServicios();
        ITransaccion reitroDeEfectivo = new RetiroDeEfectivo();
        ITransaccion transferencia = new Transferencia();

        Basic basic = new Basic(consultaDeSaldo,pagoDeServicios,reitroDeEfectivo);
        Cobrador cobrador = new Cobrador(reitroDeEfectivo,consultaDeSaldo);
        Ejecutivo ejecutivo = new Ejecutivo(deposito,transferencia);

        basic.realizarConsultaSaldo();
        cobrador.realizarRetiroEfectivo();
        ejecutivo.realizarTransferencia();
    }
}
