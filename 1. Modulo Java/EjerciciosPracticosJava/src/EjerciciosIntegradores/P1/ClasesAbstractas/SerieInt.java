package EjerciciosIntegradores.P1.ClasesAbstractas;

public class SerieInt extends Prototipo<Integer>{
    @Override
    public Integer siguienteNumero() {
        return valorSerie += suma;
    }

    @Override
    public Integer comenzarSerie(Integer valorIncial) {
        if(valorIncial == 1){
            suma = 2;
            valorSerie = valorIncial + suma;
            return valorSerie;
        }

        suma = valorIncial;
        valorSerie = valorIncial;
        return valorSerie;
    }
}
