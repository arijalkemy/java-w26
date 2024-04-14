public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivo = new Ejecutivos();
        Basic basico = new Basic();
        Cobradores cobrador = new Cobradores();

        System.out.print(ejecutivo.realizarDeposito());
        System.out.print("\n" + ejecutivo.transaccionOK());

        System.out.print("\n" + cobrador.realizarConsultaDeSaldo());
        System.out.print("\n" + cobrador.transaccionNoOK());
    }
}
