package org.bootcamp;

import org.bootcamp.cliente.Basic;
import org.bootcamp.cliente.Cobrador;
import org.bootcamp.cliente.Ejecutivo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();

        //Servicios del cliente ejecutivo
        System.out.println("\n--- Transacciones Cliente Ejecutivo ----\n");
        ejecutivo.depositar().transaccionOK();
        //ejecutivo.depositar().transaccionNoOK();
        //ejecutivo.transferir().transaccionOK();
        ejecutivo.transferir().transaccionNoOK();

        Basic basic = new Basic();

        // Servicios del cliente Basic
        System.out.println("\n\n--- Transacciones Cliente Basic ----\n");
        basic.consultarSaldo().transaccionNoOK();
        //basic.consultarSaldo().transaccionOK();
        basic.pagarServicio().transaccionOK();
        //basic.pagarServicio().transaccionNoOK();
        basic.retirarEfectivo().transaccionOK();
        //basic.retirarEfectivo().transaccionNoOK();

        Cobrador cobrador = new Cobrador();

        // Servicios del cliente Cobrador
        System.out.println("\n\n--- Transacciones Cliente Cobrador ----\n");
        cobrador.consultarSaldo().transaccionOK();
        //cobrador.consultarSaldo().transaccionNoOK();
        cobrador.retirarEfectivo().transaccionOK();
        //cobrador.retirarEfectivo().transaccionNoOK();

    }
}
