public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo {

    public Cobradores() {
    }

    @Override
    public String realizarConsultaDeSaldo() {
        return "Realizando consulta de saldo...";
    }

    @Override
    public String realizarRetiroDeEfectivo() {
        return "Realizando retiro de efectivo...";
    }

    @Override
    public String transaccionOK() {
        return "Transaccion OK";
    }

    @Override
    public String transaccionNoOK() {
        return "Transaccion no OK";
    }
}
