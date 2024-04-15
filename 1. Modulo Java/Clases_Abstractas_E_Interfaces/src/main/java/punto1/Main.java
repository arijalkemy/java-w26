package punto1;

public class Main {
    public static void main(String[] args) {
        // Creación de un cliente Ejecutivo y realización de sus operaciones
        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("Operaciones del cliente Ejecutivo:");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        // Separador para mayor claridad en la salida
        System.out.println("----------------------------------");

        // Creación de un cliente Basic y realización de sus operaciones
        Basic basic = new Basic();
        System.out.println("Operaciones del cliente Basic:");
        basic.consultaSaldo();
        basic.pagoServicios();
        basic.retiroEfectivo();

        // Separador para mayor claridad en la salida
        System.out.println("----------------------------------");

        // Creación de un cliente Cobrador y realización de sus operaciones
        Cobrador cobrador = new Cobrador();
        System.out.println("Operaciones del cliente Cobrador:");
        cobrador.consultarSaldo();
        cobrador.retiroEfectivo();
    }
}
