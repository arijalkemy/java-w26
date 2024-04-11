public class Banco {
    public static void main(String[] args){
        Cliente ejecutivo = new Ejecutivos();
        Cliente basico = new Basic();
        Cliente cobrador = new Cobradores();

        //acciones
        ejecutivo.consultar();
        ejecutivo.retirar();
        ejecutivo.transferir();

        basico.retirar();
        basico.transferir();
        basico.consultar();

        cobrador.retirar();
        cobrador.transferir();
        cobrador.consultar();
    }
}
