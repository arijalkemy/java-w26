//Clase implementadora
public class Ejecutivo implements Transaccion{
    private String nombre;
    private String documento;
    private String numeroCuenta;
    private int saldo;
    private boolean estado;

    //metodo para realizar deposito para el cliente ejecutivo
    public void realizarDeposito(int monto){
        if(this.estado){
            System.out.println("validando información...");
            System.out.println("Realizando el deposito...");
            System.out.println("Esperando respuesta del servidor...");
            this.saldo += monto;
            this.transaccionOk();
        }else{
            System.out.println("validando información...");
            System.out.println("Realizando el deposito...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionNoOk();
        }
    }
    //Metodo para realizar transferencia del ejecutivo
    public void realizarTransferencia(int monto){
        if(this.saldo>monto){
            System.out.println("validando información...");
            System.out.println("Realizando la transferencia...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionOk();
        }else {
            System.out.println("validando información...");
            System.out.println("Realizando la transferencia...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionNoOk();
        }
    }
    //Metodos implementados con la misma firma del metodo de la interface
    @Override
    public void transaccionOk() {
        System.out.println("Ejecutivo: La transacción se realizo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ejecutivo: La transacción ha sido rechazada");
    }

    //setters y Getters
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean isEstado() {
        return estado;
    }
}
