package modelo;

public abstract class Serie {

    private int valorInicial = 0;
    private int valorActual = 0;

    public int valorSiguiente(){
        valorActual = this.ejecutar();
        return valorActual;
    }

    public void reiniciar(){
        this.valorActual = valorInicial;
    }

    public void setearValorInicial(int valorInicial){
        this.valorInicial = valorInicial;
    }

    public abstract int ejecutar();

    public int getValorInicial() {
        return valorInicial;
    }

    public int getValorActual() {
        return valorActual;
    }
}
