public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivo = new Ejecutivos();
        ejecutivo.deposito();
        ejecutivo.transaccionOk();

        Basic cliente = new Basic();
        cliente.pagoServicios();
        cliente.transaccionNoOk();

        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo();
        cobrador.transaccionOk();
    }


}