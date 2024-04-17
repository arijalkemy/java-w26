public class SerieInteger extends SeriePrototipo<Integer> {

    public SerieInteger(Integer inicioSerie, Integer incrementoSerie, Integer valorActual) {
        super(inicioSerie, incrementoSerie, valorActual);
    }

    @Override
    public Integer obtenerValorSiguiente() {
        Integer nuevoValor = this.getValorActual() + this.getIncrementoSerie();
        this.setValorActual(nuevoValor);
        return nuevoValor;
    }
}
