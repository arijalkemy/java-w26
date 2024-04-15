package clasesAbstractas;

public class SerieProgresivaInteger extends SerieProgresiva<Integer> {
    public SerieProgresivaInteger(Integer valorInicial, Integer incremento){
        super(valorInicial, incremento);
    }
    @Override
    public Integer siguienteValor(){
        valorActual += incremento;
        return valorActual;
    }
}
