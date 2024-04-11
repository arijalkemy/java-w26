package org.example;

import org.example.clientes.Basic;
import org.example.clientes.Cliente;
import org.example.clientes.Cobrador;
import org.example.clientes.Ejecutivo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(" - Cliente Ejecutivo - ");
        Cliente clienteEjecutivo = new Ejecutivo();
        clienteEjecutivo.depositar();
        clienteEjecutivo.transferir();
        clienteEjecutivo.retirarEfectivo();
        clienteEjecutivo.consultarSaldo();
        clienteEjecutivo.pagarServicios();

        System.out.println(" - Cliente Basic - ");
        Cliente clienteBasico = new Basic();
        clienteBasico.depositar();
        clienteBasico.transferir();
        clienteBasico.retirarEfectivo();
        clienteBasico.consultarSaldo();
        clienteBasico.pagarServicios();

        System.out.println(" - Cliente Cobrador - ");
        Cliente clienteCobrador = new Cobrador();
        clienteCobrador.depositar();
        clienteCobrador.transferir();
        clienteCobrador.retirarEfectivo();
        clienteCobrador.consultarSaldo();
        clienteCobrador.pagarServicios();
    }
}
