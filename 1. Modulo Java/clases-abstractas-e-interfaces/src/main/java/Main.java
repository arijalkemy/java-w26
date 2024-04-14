public class Main {
    public static void main(String[] args) {

        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();


        cobrador.realizarTransaccion(new Deposito()); //noOk
        cobrador.realizarTransaccion(new RetiroEfectivo());
        cobrador.realizarTransaccion(new ConsultaSaldo());

        basic.realizarTransaccion(new Transferencia()); // noOk
        basic.realizarTransaccion(new ConsultaSaldo());
        basic.realizarTransaccion(new PagoServicio());
        basic.realizarTransaccion(new RetiroEfectivo());

        ejecutivo.realizarTransaccion(new PagoServicio()); //noOk
        ejecutivo.realizarTransaccion(new Transferencia());
        ejecutivo.realizarTransaccion(new Deposito());


    }
}
