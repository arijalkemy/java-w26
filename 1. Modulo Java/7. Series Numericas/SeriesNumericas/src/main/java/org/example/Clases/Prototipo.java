package org.example.Clases;

public abstract class Prototipo<T extends Number> {

    private T valorInicial;
    private T paso;

    public T getValorInicial() {
        return valorInicial;
    }

    public T getPaso() {
        return paso;
    }

    public void setPaso(T paso) {
        this.paso = paso;
    }

    public Prototipo(T valorInicial) {
        this.valorInicial = valorInicial;
        this.paso = null;
    }

    public T valorSiguiente(){
        T siguiente = this.valorInicial;
        this.valorInicial = sumar(this.valorInicial , this.paso);
        return siguiente;
    }

    public void reiniciarSerie(){
        this.valorInicial = null;
    }

    public void setValorInicial(T valor){
        this.valorInicial = valor;
    }

    public  T sumar (T a , T b){
        double resultado = a.doubleValue() + b.doubleValue();
        return (T) Double.valueOf(resultado);
    };
}
