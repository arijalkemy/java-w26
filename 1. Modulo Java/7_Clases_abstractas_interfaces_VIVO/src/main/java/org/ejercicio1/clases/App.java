package org.ejercicio1.clases;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar(2500);
        ejecutivo.transaccionNoOk("Deposito");
        ejecutivo.trasnferir(200, "Juli");
        ejecutivo.transaccionOk("Transferencia");

        Basic basic = new Basic();
        basic.calcularSaldo();
        basic.transaccionOk("Consulta de saldo");
        basic.pagarServicio("WiFi");
        basic.transaccionNoOk("Pago de servicio");
        basic.retiroEfectivo(500);
        basic.transaccionOk("Retiro de efectivo");

        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo(260);
        cobrador.transaccionNoOk("Retiro de efectivo");
        cobrador.calcularSaldo();
        cobrador.transaccionOk("Consulta de saldo");
    }
}
