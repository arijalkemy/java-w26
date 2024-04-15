package EjerciciosIntegradores.P2.SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static int numeroLocker;
    Map<Integer, List<Prenda>> locker;

    public GuardaRopa(){
        locker = new HashMap<>();
        numeroLocker = 0;
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        GuardaRopa.numeroLocker++;
        this.locker.put(numeroLocker, prendas);
        System.out.println("Se guardaron las prendas con la key: " + numeroLocker);
        return numeroLocker;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry : locker.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.locker.get(numero);
    }
}
