public class main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cobradores();
        Cliente cliente2 = new Ejecutivo();
        Cliente cliente3 = new Basic();

        cliente1.consultarSaldo();
        cliente1.depositar();
        cliente1.retirarEfectivo();

        cliente2.transferir();
        cliente2.depositar();

        cliente3.consultarSaldo();
        cliente3.pagarServicios();
        cliente3.retirarEfectivo();
        cliente3.transferir();
    }
}
