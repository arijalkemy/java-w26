package bootcamp.bendezujonathan;

import bootcamp.bendezujonathan.clientes.Basic;
import bootcamp.bendezujonathan.clientes.Cobrador;
import bootcamp.bendezujonathan.clientes.Ejecutivo;

public class App 
{
    public static void main( String[] args )
    {
        ejecutivo();
        basic();
        cobrador();
    }


    public static void ejecutivo() {
        Ejecutivo unEjecutivo = new Ejecutivo();
        unEjecutivo.depositar();
        unEjecutivo.transferir();
    }

    public static void basic() {
        Basic unBasic = new Basic();
        unBasic.consultarSaldo();
        unBasic.pagarServicios();
        unBasic.retirarEfectivo();
    }

    public static void cobrador() {
        Cobrador unCobrador = new Cobrador();
        unCobrador.consultarSaldo();
        unCobrador.retirarEfectivo();
    }
}
