public class SerieDouble extends SeriePrototipo<Double>{

    public SerieDouble(Double inicioSerie, Double incrementoSerie, Double valorActual) {
        super(inicioSerie, incrementoSerie, valorActual);
    }

    @Override
    public Double obtenerValorSiguiente() {
        Double nuevoValor = this.getValorActual() + this.getIncrementoSerie();
        this.setValorActual(nuevoValor);
        return nuevoValor;
    }
}
