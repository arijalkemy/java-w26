public class Basic implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo {

    @Override
    public String realizarConsultaDeSaldo() {
        return "Realizando consulta de saldo...";
    }

    @Override
    public String realizarPagoDeServicios() {
        return "Realizando pago de servicios...";
    }

    public Basic() {
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
