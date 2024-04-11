package Ejercicio1;


/**
 * Ejercicio1 de la practica de interface y clases abstractas
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        org.example.Clases.Basic personaBasic = new org.example.Clases.Basic();
        org.example.Clases.Cobrador personaCobrador = new org.example.Clases.Cobrador();
        org.example.Clases.Ejecutivo personaEjecutivo = new org.example.Clases.Ejecutivo();

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
