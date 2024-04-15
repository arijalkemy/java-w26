package clasesAbstractas;

public class SerieProgresivaDoble extends SerieProgresiva<Double>{
    public SerieProgresivaDoble(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }
    @Override
    public Double siguienteValor(){
        valorActual+=incremento;
        return valorActual;
    }
}
