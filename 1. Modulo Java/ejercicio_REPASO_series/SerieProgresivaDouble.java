public class SerieProgresivaDouble extends Prototipo <Double> {
    public SerieProgresivaDouble(double valorInicial, double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Double getValorSiguiente() {
        valorActual += incremento;
        return valorActual;
    }
}
