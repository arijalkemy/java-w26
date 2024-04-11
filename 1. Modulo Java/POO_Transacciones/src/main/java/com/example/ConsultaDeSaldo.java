package com.example;

public class ConsultaDeSaldo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado la consulta de saldo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un problema al consultar el saldo.");
    }
    
}
