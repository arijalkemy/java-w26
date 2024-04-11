import Clientes.Basic;
import Clientes.Cobrador;
import Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ejecutando transacciones para cliente EJECUTIVO");
        Ejecutivo clienteEjecutivo = new Ejecutivo();
        clienteEjecutivo.depositar();
        clienteEjecutivo.transferir();

        System.out.println("--------------------------");
        System.out.println("Ejecutando transacciones para cliente BASIC");
        Basic clienteBasic = new Basic();
        clienteBasic.consultarSaldo();
        clienteBasic.pagarServicio();
        clienteBasic.retirarEfectivo();

        System.out.println("--------------------------");
        System.out.println("Ejecutando transacciones para cliente COBRADOR");
        Cobrador clienteCobrador = new Cobrador();
        clienteCobrador.consultarSaldo();
        clienteCobrador.retirarEfectivo();
    }
}