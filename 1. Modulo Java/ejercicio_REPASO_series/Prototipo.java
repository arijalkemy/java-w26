public abstract class Prototipo <T extends Number> {
    protected T valorActual;
    protected T incremento;

    public Prototipo(T valorInicial, T incremento){
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public abstract T getValorSiguiente();

    public void reset(){

    }

    public void setValorInicial(T valorInicial) {
        this.valorActual = valorInicial;
    }
}
