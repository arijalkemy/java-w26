public class Basic implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion básica correcta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion básica no correcta");
    }

    public void consultaSaldo() {
        System.out.println("Consultando saldo.");
    }

    public void pagoServicios() {
        System.out.println("Realizando pago de servicios.");
    }

    public void retiroEfectivo() {
        System.out.println("Realizando retiro de efectivo.");
    }
}
