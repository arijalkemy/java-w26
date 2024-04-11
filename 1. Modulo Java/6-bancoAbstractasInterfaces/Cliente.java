public abstract class Cliente {
    String nombre;
    public void depositar(){
        String accion = "Deposito";
        System.out.println("Realizando " + accion);
    }

    public void transferir() {
        String accion = "Transferencia";
        System.out.println("Realizando " + accion);
    }

    public void consultar(){
        String accion = "Consulta de Saldo";
        System.out.println("Realizando " + accion);
    }

    public void pagar(){
        String accion = "Pago de Servicios";
        System.out.println("Realizando " + accion);
    }

    public void retirar(){
        String accion = "Retiro de Efectivo";
        System.out.println("Realizando " + accion);
    }

}
