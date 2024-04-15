package ClasesAbstractasInterfaces.Banco;


import ClasesAbstractasInterfaces.Banco.cliente.Basic;
import ClasesAbstractasInterfaces.Banco.cliente.Cobrador;
import ClasesAbstractasInterfaces.Banco.cliente.Ejecutivo;
import ClasesAbstractasInterfaces.Banco.transaccion.Transaccion;

public class Main {
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        ejecutivo.realizarDeposito(2000, Transaccion.transaccionOk());
        basic.pagarServicio(Transaccion.transaccionNoOk());
        cobrador.retirarEfectivo(5000, Transaccion.transaccionOk());
    }
}
