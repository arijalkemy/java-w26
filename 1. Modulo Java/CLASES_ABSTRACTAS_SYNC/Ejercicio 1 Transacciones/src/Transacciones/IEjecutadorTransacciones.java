package Transacciones;

import java.util.Random;

public interface IEjecutadorTransacciones {
    public static void ejecutar(Transaccion transaccion)
    {
        Random random = new Random();
        int estado = random.nextInt(2);
        if (estado != 0) {
            transaccion.ok();
        } else {
            transaccion.noOk();
        }
        System.out.println(" ");
    }
}
