public class SerieProgresivaInt extends Prototipo<Integer> {
    public SerieProgresivaInt(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer getValorSiguiente() {
        valorActual += incremento;
        return valorActual;
    }
}
