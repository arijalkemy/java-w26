import Clientes.Basic;
import Clientes.Cobradores;
import Clientes.Ejecutivo;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.transferir();
        ejecutivo.depositar();

        Cobradores cobrador = new Cobradores();
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();

        Basic basico = new Basic();
        basico.consultarSaldo();
        basico.retirarEfectivo();
        basico.pagarServicios();

    }
}
