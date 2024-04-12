public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Ejecutivo();
        Cliente cliente2 = new Basic();
        Cliente cliente3 = new Cobrador();

        Transaccion transaccion1 = new Deposito();
        Transaccion transaccion2 = new Transferencia();
        Transaccion transaccion3 = new ConsultaDeSaldo();
        Transaccion transaccion4 = new PagoServicios();
        Transaccion transaccion5 = new RetiroDeEfectivo();
        Transaccion transaccion6 = new RetiroDeEfectivo();

        cliente1.realizarTransaccion(transaccion1);
        cliente1.realizarTransaccion(transaccion3);



    }
}
