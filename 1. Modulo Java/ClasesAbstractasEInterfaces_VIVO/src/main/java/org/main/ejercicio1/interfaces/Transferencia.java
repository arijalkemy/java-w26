package org.main.ejercicio1.interfaces;

public interface Transferencia extends Transaccion{
    public String transferenciaOK(String destino,Double monto);
    public String transferenciaNoOK(String destino, Double monto);
}
