public class Main {
    public static void main(String[] args) {

        System.out.println("Ejecutivo");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.transaccionOk();

        System.out.println("\nBasic");
        Basic basic = new Basic();
        basic.realizarConsultaSaldo();
        basic.transaccionNoOk();

        System.out.println("\nCobrador");
        Cobrador cobrador = new Cobrador();
        cobrador.realizarRetiroEfectivo();
        cobrador.transaccionOk();
    }
}