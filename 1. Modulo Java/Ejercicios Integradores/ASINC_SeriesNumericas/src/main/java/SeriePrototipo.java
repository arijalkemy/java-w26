public abstract class SeriePrototipo<T> {
    private T valorInicioSerie;
    private T incrementoSerie;
    private T valorActual;

    public SeriePrototipo(T inicioSerie, T incrementoSerie, T valorActual) {
        this.valorInicioSerie = inicioSerie;
        this.incrementoSerie = incrementoSerie;
        this.valorActual = valorActual;
    }

    public T getInicioSerie() {
        return valorInicioSerie;
    }

    public void setInicioSerie(T inicioSerie) {
        this.valorInicioSerie = inicioSerie;
    }

    public T getIncrementoSerie() {
        return incrementoSerie;
    }

    public void setIncrementoSerie(T incrementoSerie) {
        this.incrementoSerie = incrementoSerie;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public abstract T obtenerValorSiguiente();

    public void reiniciarSerie() {
        this.valorActual = valorInicioSerie;
    };

    public void establecerValorInicial(T nuevoValorInicial) {
        this.valorInicioSerie = nuevoValorInicial;
        reiniciarSerie();
    }
}
