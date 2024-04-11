package org.example;

import org.example.Clases.Basic;
import org.example.Clases.Cobrador;
import org.example.Clases.Ejecutivo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Basic personaBasic = new Basic();
        Cobrador personaCobrador = new Cobrador();
        Ejecutivo personaEjecutivo = new Ejecutivo();

        personaBasic.pagarServicios();
        personaBasic.consultarSaldo();
        personaBasic.retirarEfectivo();
        personaBasic.transaccionOk();
        personaBasic.transaccionNoOk();

        personaCobrador.consultarSaldo();
        personaCobrador.retirarEfectivo();
        personaCobrador.transaccionNoOk();
        personaCobrador.transaccionOk();

        personaEjecutivo.RealizarDeposito();
        personaEjecutivo.realizarTransferencia();
        personaEjecutivo.transaccionNoOk();
        personaEjecutivo.RealizarDeposito();


    }
}
