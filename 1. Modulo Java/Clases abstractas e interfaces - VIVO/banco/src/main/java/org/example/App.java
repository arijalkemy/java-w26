package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobradores cobradores = new Cobradores();


        // ninguna de las siguientes acciones va a llegar a fallar ya que no hay una condicion que haga fallar los try catch
        ejecutivo.depositos();
        ejecutivo.transferencias();
        basic.consultarSaldo();
        basic.retirarDinero();
        basic.pagoServicios();
        cobradores.consultarSaldo();
        cobradores.retirarDinero();
    }
}
