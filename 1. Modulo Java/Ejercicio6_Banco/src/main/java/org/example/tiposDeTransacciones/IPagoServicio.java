package org.example.tiposDeTransacciones;

public interface IPagoServicio extends ITransaccion {

    public void pagarServicio(int cantidad, String entidadAPagar);
}
