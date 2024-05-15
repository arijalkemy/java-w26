package EjercicioBanco;

public interface Transaccion {

    public boolean transaccionOK(String transaccion);
    public void transaccionNoOK(String transaccion);

    public void  intentarTransaccion(String transaccion);
}
