//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se crean los 3 tipos de clientes del banco
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        //Se realizan las operaciones para cada tipo de cliente
        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Ejecutivo");
        ejecutivo.realizarTransferencia(6000);
        ejecutivo.realizarDeposito(23425);

        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Basic");
        basic.consultarSaldo();
        basic.pagoServicios(1341234);
        basic.retirarEfectivo(12341234);

        System.out.println("----------------------------");
        System.out.println("Operaciones de cliente - Cobradores");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(2341234);
    }
}