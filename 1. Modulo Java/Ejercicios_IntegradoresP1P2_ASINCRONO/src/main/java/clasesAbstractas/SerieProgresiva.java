package clasesAbstractas;

public abstract class SerieProgresiva <T extends Number> {
    protected T valorActual;
    protected T incremento;

    public SerieProgresiva(T valorInicial, T incremento){
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }
    public abstract T siguienteValor();
    public void reiniciar(){
        valorActual=incremento;
    }
    public void setValorActual(T valorInicial){
        this.valorActual = valorInicial;
    }
    public void setValorInicial(T valorInicial) {
        this.valorActual = valorInicial;  // Establece el valor actual al valor inicial proporcionado
    }

}
