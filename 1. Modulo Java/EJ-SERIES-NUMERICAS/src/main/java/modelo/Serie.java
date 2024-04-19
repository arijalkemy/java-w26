package modelo;

public abstract class Serie<T extends Number> {

    private T valorInicial;
    private T valorActual;


    public Serie(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public T valorSiguiente(){
        valorActual = this.ejecutar();
        return valorActual;
    }

    public void reiniciar(){
        this.valorActual = valorInicial;
    }

    public void setearValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
    }

    public abstract T ejecutar();

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }
}
