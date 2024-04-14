public abstract class Prototipo<T extends Number> {
    protected T nroInicial;
    protected T nroActual;

    public Prototipo(T nroInicial) {
        this.nroInicial = nroInicial;
        this.nroActual = nroInicial;
    }

    public T getNroInicial() {
        return nroInicial;
    }

    public void setNroInicial(T nroInicial) {
        this.nroInicial = nroInicial;
    }

    public T getNroActual() {
        return nroActual;
    }

    public void setNroActual(T nroActual) {
        this.nroActual = nroActual;
    }

    public abstract T devolverSiguiente();

    public void reiniciarSerie(){
        nroActual = nroInicial;
    }
    public void establecerValorInicialSerie(T nroInicioSerie){
        this.nroInicial = nroInicioSerie;
        this.nroActual = nroInicioSerie;
    }
}
