package EjerciciosIntegradores.P1.ClasesAbstractas;

public class SerieDouble extends Prototipo<Double>{
    @Override
    public Double siguienteNumero() {
        return valorSerie += suma;
    }

    @Override
    public Double comenzarSerie(Double valorIncial) {
        if(valorIncial == 1.0){
            suma = 2.0;
            valorSerie = valorIncial + suma;
            return valorSerie;
        }

        suma = valorIncial;
        valorSerie = valorIncial;
        return valorSerie;
    }
}
