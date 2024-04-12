package org.example.tiposDeTransacciones;

public interface PagoServicio extends Transaccion {

    public void pagarServicio(int cantidad, String entidadAPagar);
}
