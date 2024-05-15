package EjercicioBanco;

import java.util.ArrayList;
import java.util.List;

public class Basic implements Transaccion {
    List<String> transaccionesPermitidas = new ArrayList<>();


    public boolean transaccionOK(String transaccion) {
        if(transaccionesPermitidas.contains(transaccion)){
            System.out.println("Operacion permitida");
            return true;
        }
        return  false;
    }


    @Override
    public void transaccionNoOK(String transaccion) {
        if(!transaccionesPermitidas.contains(transaccion)){
            System.out.println("Esta operación no esta autorizada");
        }

    }

    public Basic(List<String> transaccionesPermitidas) {
        this.transaccionesPermitidas = transaccionesPermitidas;
    }

    public void  intentarTransaccion(String transaccion){
        if (transaccionOK(transaccion)){
            System.out.println("Transacción permitida, ejecutando: "+ transaccion);
        }
        else {
            System.out.println("Esta operación no esta autorizada");
        }
    }
}
