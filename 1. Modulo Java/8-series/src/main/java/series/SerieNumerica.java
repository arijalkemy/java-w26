package series;

public abstract class SerieNumerica<T extends Number> {
    private T valorActual;
    private T valorInicial;

    public void marcarInicio (T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract T computarSiguiente();

    public void reiniciarSerie() {
        this.valorActual = this.valorInicial;
    };

    // Getters y setters

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

}
