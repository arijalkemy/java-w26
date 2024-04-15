public class Basic implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ejecutada correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida.");
    }

    public void realizarConsultaSaldo() {
        System.out.println("Realizando consulta de saldo.");
    }

    public void realizarPagoServicios() {
        System.out.println("Realizando pago de servicios.");
    }

    public void realizarRetiroEfectivo() {
        System.out.println("Realizando retiro de efectivo.");
    }
}