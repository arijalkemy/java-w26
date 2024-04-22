package org.example;

public class Cobrador extends Cliente{

    public Cobrador(String nombre_apellido) {
        super(nombre_apellido);
    }

    public void depositar() {

    }

    public void transferir() {

    }

    @Override
    public void consultar_saldo() {
        System.out.println(super.nombre_apellido + "Hizo una consulta de saldo");
    }

    public void pagar_servicio() {

    }

    @Override
    public void retirar_efectivo() {
        System.out.println(super.nombre_apellido + "Hizo un retiro de efectivo");
    }
}
